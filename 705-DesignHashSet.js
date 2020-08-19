/**
 * implement hashset by using linkedList
 * To handle collision, use linked list to do seperate chaining
 */
class Node {
  constructor(key) {
    this.key = key;
    this.next = null;
  }
}

/**
 * Initialize your data structure here.
 */
var MyHashSet = function () {
  this.linkedList = [];
  this.size = 10000; // avoid collision
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function (key) {
  const i = this.hash(key);
  // create a dummy head in this index of array
  if (this.linkedList[i] == null) this.linkedList[i] = new Node(-1);
  // find the previous node
  const prev = this.find(this.linkedList[i], key);
  if (prev.next == null) prev.next = new Node(key);
  else prev.next.key = key;
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function (key) {
  const i = this.hash(key);
  if (this.linkedList[i] == null) return;
  const prev = this.find(this.linkedList[i], key);
  if (prev.next == null) return;
  prev.next = prev.next.next;
};

/**
 * Returns true if this set contains the specified element
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function (key) {
  const i = this.hash(key);

  if (this.linkedList[i] == null) return false;

  const prev = this.find(this.linkedList[i], key);
  return prev.next == null ? false : true;
};

MyHashSet.prototype.hash = function (key) {
  return key % this.size;
};

/**
 * find the specified node in the linkedList
 * @param {Node} bucket
 * @param {number} key
 * @return {Node}
 */
MyHashSet.prototype.find = function (bucket, key) {
  // to find the corrct the node before the given key
  // (-1) => (1) => (10001) => (20001)
  // in this case find((1), 43) will return (10001)
  // which is the previous one
  let node = bucket;
  let prev = null;
  while (node != null && node.key != key) {
    prev = node;
    node = node.next;
  }
  return prev;
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */

var obj = new MyHashSet();
obj.add(1);
obj.add(2);
var param_1 = obj.contains(1);
// var param_2 = obj.contains(2);
var param_3 = obj.contains(3);
console.log(param_1);
// console.log(param_2);
console.log(param_3);
obj.remove(2);
console.log(obj.contains(2));
