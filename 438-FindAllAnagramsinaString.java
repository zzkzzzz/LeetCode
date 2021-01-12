import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution438 {
    public List<Integer> findAnagrams(String s, String t) {
        // store what we need in window
        Map<Character, Integer> need = new HashMap<>();
        // store current character in window
        Map<Character, Integer> window = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        for (char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);

        // left and right to represent a window
        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s.length()) {
            // move right to find a valid window.
            char c = s.charAt(right);
            right++;

            // update window hashmap
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // when a valid window is found, move left to find a smaller window.
            while (right - left >= t.length()) {

                if (valid == need.size())
                    result.add(left);

                // d is going to remove from window
                char d = s.charAt(left);
                // shrink the window
                left++;
                // update window hashmap
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }

            }
        }

        return result;
    }
}