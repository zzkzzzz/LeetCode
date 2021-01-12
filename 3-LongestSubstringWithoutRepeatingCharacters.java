import java.util.Map;
import java.util.HashMap;

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        // store current character in window
        Map<Character, Integer> window = new HashMap<>();

        // left and right to represent a window
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < s.length()) {
            // move right to find a valid window.
            char c = s.charAt(right);
            right++;

            // update window hashmap
            window.put(c, window.getOrDefault(c, 0) + 1);

            // when a valid window is found, move left to find a smaller window.
            while (window.get(c) > 1) {
                // d is going to remove from window
                char d = s.charAt(left);
                // shrink the window
                left++;
                // update window hashmap
                window.put(d, window.get(d) - 1);

            }

            res = Math.max(res, right - left);
        }

        return res;
    }
}