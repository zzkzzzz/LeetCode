
class Solution670 {
    public int maximumSwap(int num) {
        String temp = Integer.toString(num);
        int[] nums = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            nums[i] = temp.charAt(i) - '0';
        }

        int[] buckets = new int[10];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i]] = i;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 9; j > nums[i]; j--) {
                // the number must behind the i
                if (buckets[j] > i) {
                    int replace = nums[i];
                    nums[i] = nums[buckets[j]];
                    nums[buckets[j]] = replace;

                    StringBuilder s = new StringBuilder();
                    for (int k : nums) {
                        s.append(k); // add all the ints to a string
                    }

                    return Integer.parseInt(s.toString()); // parse integer out of the string
                }
            }
        }

        return num;
    }
}