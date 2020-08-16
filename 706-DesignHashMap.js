/* Notes
implement hashmap by using linkedlist
To handle collision, use linked list to do seperate chaining
*/
class Node {
  // constructor
  constructor(key, val) {
    this.key = key;
    this.val = val;
    this.next = null;
  }
}

/**
 * Initialize your data structure here.
 */
var MyHashMap = function () {
  this.linkedList = [];
  this.size = 10000;
};

/**
 * value will always be non-negative.
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function (key, value) {
  const i = this.idx(key);
  // explainion
  // put(1,1), idx(1) = 1, find function returns dummy head(-1,-1),
  // append a new tail: nodes[1]: (key:-1,value:-1) -> (1,1)
  // put(100001,1), idx(100001) = 1(same bucket), find function returns (1,1),
  // create a new tail: yields nodes[1] (-1,-1) -> (1,1) -> (100001, 1)
  // the key is in the find function how to locate the correct value in the same bucket using node.key != key
  if (this.linkedList[i] == null) this.linkedList[i] = new Node(-1, -1);
  const prev = this.find(this.linkedList[i], key);
  if (prev.next == null) prev.next = new Node(key, value);
  else prev.next.val = value;
};

/**
 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function (key) {
  const i = this.idx(key);
  if (this.linkedList[i] == null) return -1;
  const node = this.find(this.linkedList[i], key);
  return node.next == null ? -1 : node.next.val;
};

/**
 * Removes the mapping of the specified value key if this map contains a mapping for the key
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function (key) {
  const i = this.idx(key);
  if (this.linkedList[i] == null) return;
  const prev = this.find(this.linkedList[i], key);
  if (prev.next == null) return;
  prev.next = prev.next.next;
};

/**
 * index the key
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.idx = function (key) {
  // suppose to use hashing algorithm (e.g. fmix64) to convert a non-uniform distribution dataset to a uniform distribution data,
  // so that the collision rate can be lowered.
  return key % this.size;
};

/**
 * find the specified node in the linkedList
 * @param {Node} bucket
 * @param {number} key
 * @return {Node}
 */
MyHashMap.prototype.find = function (bucket, key) {
  // to find the corrct the node before the given key
  // (-1,-1) => (1,23) => (10001,32) => (20001,43)
  // in this case find((1,23), 43) will return (10001,32)
  // which is the previous one of (20001,43)
  let node = bucket;
  let prev = null;
  while (node != null && node.key != key) {
    prev = node;
    node = node.next;
  }
  return prev;
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */

var obj = new MyHashMap();
obj.put(1, 1);
obj.put(2, 2);
obj.put(3, 3);
var param_1 = obj.get(1);
var param_2 = obj.get(2);
var param_3 = obj.get(3);
console.log(param_1);
console.log(param_2);
console.log(param_3);
// obj.remove(1);
// console.log(obj);
// console.log(obj.get(2));
// obj.put(3, 9);
// console.log(obj.get(3));
