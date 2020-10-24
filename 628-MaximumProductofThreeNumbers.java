import java.util.PriorityQueue;
import java.util.Collections;

class Solution628 {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE,
                min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }

    public int maximumProduct2(int[] nums) {
        // fixed size of 3 positive numbers
        PriorityQueue<Integer> poheap = new PriorityQueue<>(3);
        // fixed size of 2 negative numbers
        PriorityQueue<Integer> neheap = new PriorityQueue<>(2, Collections.reverseOrder());
        for (int num : nums) {
            poheap.offer(num);
            neheap.offer(num);
            if (poheap.size() > 3) {
                poheap.poll();
            }
            if (neheap.size() > 2) {
                neheap.poll();
            }
        }
        int product1 = 1;
        int product2 = 0;
        // product1 = product of largest 3 positive number
        while (!poheap.isEmpty()) {
            // get the largest positive number
            product2 = poheap.poll();
            product1 *= product2;
        }
        // product2 = largest positive number * 2 smallest negative number
        while (!neheap.isEmpty()) {
            product2 *= neheap.poll();
        }
        return Math.max(product1, product2);
    }
}