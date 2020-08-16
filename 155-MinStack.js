/**
 * initialize your data structure here.
 */
var MinStack = function () {
  this.items = [];
};

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function (x) {
  this.items.push(x);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function () {
  // return top most element in the stack
  // and removes it from the stack
  // Underflow if stack is empty
  if (this.items.length == 0) return -1;
  this.items.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function () {
  // return the top most element from the stack
  // but does'nt delete it.
  return this.items[this.items.length - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function () {
  const sorted = [...this.items];
  return sorted.sort((a, b) => a - b)[0];
};

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

var obj = new MinStack();
obj.push(5);
obj.push(4);
obj.push(9);

var param_3 = obj.top();
var param_4 = obj.getMin();
console.log(param_3);
console.log(param_4);
