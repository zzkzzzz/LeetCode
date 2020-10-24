import java.util.Set;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution414 {
    // only for 3th max
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3))
                continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

    // works for nth max
    public int thirdMax2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.add(n)) {
                pq.offer(n);
                if (pq.size() > 3)
                    pq.poll();
            }
        }
        if (pq.size() == 2)
            pq.poll();
        return pq.peek();
    }
}