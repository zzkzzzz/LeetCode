class Node {
  // constructor
  constructor(key, element) {
    this.element = element;
    this.key = key;
    this.next = null;
    this.prev = null;
  }
}

// linkedlist class
class LinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  /**
   * insert node to the head of the linkedlist
   * @param  {Node} element the node element
   */
  add_front(key, element) {
    const node = new Node(key, element);
    if (this.head === null) {
      this.head = node;
      this.tail = node;
    } else {
      this.head.prev = node;
      node.prev = null;
      node.next = this.head;
      this.head = node;
    }
    this.size++;
  }

  /**
   * get the node of the index
   * @param  {Integer} index
   * @return {Node}
   */
  getNodeAtIndex(index) {
    if (index >= this.size || index < 0) {
      return console.log("index out of range");
    }
    let currentIndex = 0;
    let currentNode = this.head;
    while (currentIndex !== index) {
      currentNode = currentNode.next;
      currentIndex++;
    }
    return currentNode;
  }

  /**
   * insert node before the element
   * @param  {Node} node
   * @return {Boolean}
   */
  delete_node(node) {
    const pre = node.prev;
    const next = node.next;

    if (!pre && !next) {
      this.tail = null;
      this.head = null;
      this.size--;
      return;
    }

    if (!next) {
      this.tail = node.prev || null;
      pre.next = next;
      this.size--;
      return;
    }
    if (!pre) {
      this.head = node.next || null;
      next.prev = pre;
      this.size--;
      return;
    }

    // if (node == this.head) {
    //   this.head = node.next || null;
    //   next.prev = pre;
    //   this.size--;
    //   return;
    // }
    // if (node == this.tail) {
    //   this.tail = node.prev || null;
    //   pre.next = next;
    //   this.size--;
    //   return;
    // }

    pre.next = next;
    next.prev = pre;
    this.size--;
  }

  /**
   * print the ndoe list
   */
  printList() {
    if (this.head) {
      let current = this.head;
      while (current.next) {
        console.log(current.element);
        current = current.next;
      }
      console.log(current.element);
    } else {
      console.log("empty list");
    }
  }
}

/**
 * @param {number} capacity
 */
var LRUCache = function (capacity) {
  this.map = new Map();
  this.linkedList = new LinkedList();
  this.size = capacity;
};

/**
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function (key) {
  if (this.map.has(key)) {
    const node = this.map.get(key);
    const value = node.element;
    // add the value to head
    this.linkedList.add_front(key, value);

    if (node.prev) node.prev.next = node.next;
    else this.linkedList.head = node.next;
    if (node.next) node.next.prev = node.prev;
    else this.linkedList.tail = node.prev;

    return value;
  } else return -1;
};

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function (key, value) {
  if (this.map.has(key)) {
    // move the node to head
    this.linkedList.add_front(key, value);
    this.linkedList.delete_node(this.map.get(key));

    // update map
    this.map.set(key, this.linkedList.head);
    return;
  }
  // check list capacity
  if (this.map.size < this.size) {
    // if not full
    // add to the head of linkedlist
    this.linkedList.add_front(key, value);
    // add to the map
    this.map.set(key, this.linkedList.head);
  } else {
    // if full
    // remove from Map
    this.map.delete(this.linkedList.tail.key);
    // remove the tail of the linkedlist
    this.linkedList.delete_node(this.linkedList.tail);
    // add to the head of linkedlist
    this.linkedList.add_front(key, value);
    // add to the map
    this.map.set(key, this.linkedList.head);
  }
};
LRUCache.prototype.print = function () {
  this.linkedList.printList();
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

var cache = new LRUCache(2);
cache.put(2, 6);
cache.put(1, 5);
cache.put(1, 2);
console.log(cache.get(1));
console.log(cache.get(2));
