/**
 * use two stack , one for all the inputs.
 * move all the elements from the this stack to the other one.
 * It will reverse the order to implement the queue
 *
 * The loop in peek does the moving from input to output stack.
 * Each element only ever gets moved like that once, though, and only after we already spent time pushing it,
 * so the overall amortized cost for each operation is O(1).
 */

// Stack class
class Stack {
  // Array is used to implement stack
  constructor() {
    this.items = [];
  }

  // Functions to be implemented
  // push function
  push(element) {
    // push element into the items
    this.items.push(element);
  }

  // pop function
  pop() {
    // and removes it from the stack
    // return top most element in the stack
    // Underflow if stack is empty
    if (this.items.length == 0) return "Underflow";
    return this.items.pop();
  }

  // peek function
  peek() {
    // return the top most element from the stack
    // but does'nt delete it.
    return this.items[this.items.length - 1];
  }

  // isEmpty function
  isEmpty() {
    // return true if stack is empty
    return this.items.length == 0;
  }

  // printStack function
  printStack() {
    var str = "";
    for (var i = 0; i < this.items.length; i++) str += this.items[i] + " ";
    return str;
  }
}

/**
 * Initialize your data structure here.
 */
var MyQueue = function () {
  this.input = new Stack();
  this.output = new Stack();
};

/**
 * Push element x to the back of queue.
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function (x) {
  this.input.push(x);
};

/**
 * Removes the element from in front of queue and returns that element.
 * @return {number}
 */
MyQueue.prototype.pop = function () {
  this.peek();
  return this.output.pop();
};

/**
 * Get the front element.
 * @return {number}
 */
MyQueue.prototype.peek = function () {
  if (this.output.isEmpty()) {
    while (!this.input.isEmpty()) this.output.push(this.input.pop());
  }
  return this.output.peek();
};

/**
 * Returns whether the queue is empty.
 * @return {boolean}
 */
MyQueue.prototype.empty = function () {
  return this.input.isEmpty() && this.output.isEmpty();
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */

var obj = new MyQueue();
obj.push(1);
obj.push(2);
obj.push(4);
console.log(obj.peek());
console.log(obj.pop());
console.log(obj.pop());
obj.push(5);
console.log(obj.pop());
console.log(obj.pop());
