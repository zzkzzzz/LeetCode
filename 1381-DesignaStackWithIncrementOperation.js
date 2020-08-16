/* 
Notes

Lazy increment=> use extra array to store increment value
Time Complexity: O(1)
Space Complexity; O(N) =>extra array inc

Busy increment=> loop over list to increment
Time Complexity: O(N)
Space Complexity; O(1) it does not require extra space

*/
/**
 * @param {number} maxSize
 */
var CustomStack = function (maxSize) {
  this.items = [];
  this.maxSize = maxSize;
  this.inc = this.inc = new Array(maxSize).fill(0);
};

/**
 * @param {number} x
 * @return {void}
 */
CustomStack.prototype.push = function (x) {
  if (this.items.length < this.maxSize) this.items.push(x);
};

/**
 * @return {number}
 */
CustomStack.prototype.pop = function () {
  //   if (this.items.length == 0) return -1;
  //   return this.items.pop();

  // Lazy increment
  const i = this.items.length - 1;

  if (i < 0) return -1;
  if (i > 0) this.inc[i - 1] = this.inc[i - 1] + this.inc[i];

  const res = this.items.pop() + this.inc[i];

  this.inc[i] = 0;
  return res;
};

/**
 * @param {number} k
 * @param {number} val
 * @return {void}
 */
CustomStack.prototype.increment = function (k, val) {
  // use for loop to loop through the stack to increment
  // time complexity is O(n)
  //   for (let i = 0; i < (k < this.items.length ? k : this.items.length); i++) {
  //     this.items[i] = this.items[i] + val;
  //   }

  const i = Math.min(k, this.items.length) - 1;
  if (i >= 0) this.inc[i] = val + this.inc[i];
};

/**
 * Your CustomStack object will be instantiated and called as such:
 * var obj = new CustomStack(maxSize)
 * obj.push(x)
 * var param_2 = obj.pop()
 * obj.increment(k,val)
 */

var obj = new CustomStack(3);
obj.push(1);
// obj.push(2);
// var param_2 = obj.pop();
// console.log(param_2);
// obj.push(2);
// obj.push(3);
// obj.push(4);
// console.log(obj);
// obj.increment(5, 100);
// obj.increment(2, 100);
// console.log(obj);
// console.log(obj.pop());
// console.log(obj.pop());
// console.log(obj.pop());
// console.log(obj.pop());

obj.increment(5, 100);
obj.increment(10, 100);
obj.increment(20, 100);
console.log(obj.inc);
console.log(obj.pop());
