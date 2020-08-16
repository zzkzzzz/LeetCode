/* Notes
evrytime after push new element
loop through the Queue until reach the new element
dequeue the element then edqueue again
in the end, it will reverse the queue
 */

class Queue {
  // Array is used to implement a Queue
  constructor() {
    this.items = [];
  }

  // Functions to be implemented
  // enqueue function
  enqueue(element) {
    // adding element to the queue
    this.items.push(element);
  }
  // dequeue function
  dequeue() {
    // removing element from the queue
    // returns underflow when called
    // on empty queue
    if (this.isEmpty()) return "Underflow";
    return this.items.shift();
  }
  // front function
  front() {
    // returns the Front element of
    // the queue without removing it.
    if (this.isEmpty()) return "No elements in Queue";
    return this.items[0];
  }
  // isEmpty function
  isEmpty() {
    // return true if the queue is empty.
    return this.items.length == 0;
  }
  // printQueue function
  printQueue() {
    var str = "";
    for (var i = 0; i < this.items.length; i++) str += this.items[i] + " ";
    return str;
  }
}

/**
 * Initialize your data structure here.
 */
var MyStack = function () {
  this.queue = new Queue();
};

/**
 * Push element x onto stack.
 * time complexity => O(n)
 * @param {number} x
 * @return {void}
 */
MyStack.prototype.push = function (x) {
  this.queue.enqueue(x);
  while (this.queue.front() !== x) {
    this.queue.enqueue(this.queue.front());
    this.queue.dequeue();
  }
};

/**
 * Removes the element on top of the stack and returns that element.
 * @return {number}
 */
MyStack.prototype.pop = function () {
  return this.queue.dequeue();
};

/**
 * Get the top element.
 * @return {number}
 */
MyStack.prototype.top = function () {
  return this.queue.front();
};

/**
 * Returns whether the stack is empty.
 * @return {boolean}
 */
MyStack.prototype.empty = function () {
  return this.queue.isEmpty();
};

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = new MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */

// Test
var obj = new MyStack();
obj.push(1);
obj.push(2);
obj.push(3);
obj.push(4);
console.log(obj);
var param_2 = obj.pop(); // should return 4
console.log(param_2);
var param_3 = obj.top(); //should return 3
console.log(param_3);
var param_4 = obj.empty(); // should return false
console.log(param_4);
