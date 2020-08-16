/*Notes
 use two pointers (front and rear) to make the time complexity to O(1)
*/

/**
 * Initialize your data structure here. Set the size of the queue to be k.
 * @param {number} k
 */
var MyCircularQueue = function (k) {
  this.items = [];
  this.maxSize = k;
  this.front = 0;
  this.rear = 0;
  this.size = 0;
};

/**
 * Insert an element into the circular queue. Return true if the operation is successful.
 * @param {number} value
 * @return {boolean}
 */
MyCircularQueue.prototype.enQueue = function (value) {
  if (this.isFull()) return false;
  this.items[this.rear] = value;
  this.rear = (this.rear + 1) % this.maxSize;
  this.size++;
  return true;
};

/**
 * Delete an element from the circular queue. Return true if the operation is successful.
 * @return {boolean}
 */
MyCircularQueue.prototype.deQueue = function () {
  if (this.isEmpty()) return false;
  this.front = (this.front + 1) % this.maxSize;
  this.size--;
  return true;
};

/**
 * Get the front item from the queue.
 * @return {number}
 */
MyCircularQueue.prototype.Front = function () {
  if (this.isEmpty()) return -1;
  return this.items[this.front];
};

/**
 * Get the last item from the queue.
 * @return {number}
 */
MyCircularQueue.prototype.Rear = function () {
  if (this.isEmpty()) return -1;
  return this.items[this.rear == 0 ? this.maxSize - 1 : this.rear - 1];
};

/**
 * Checks whether the circular queue is empty or not.
 * @return {boolean}
 */
MyCircularQueue.prototype.isEmpty = function () {
  return this.size === 0;
};

/**
 * Checks whether the circular queue is full or not.
 * @return {boolean}
 */
MyCircularQueue.prototype.isFull = function () {
  return this.size == this.maxSize ? true : false;
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = new MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */
