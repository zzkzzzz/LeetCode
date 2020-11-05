import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            int start = i;
            while (i < s.length() && c == s.charAt(i))
                i++;
            if (i - start >= 3)
                result.add(new ArrayList<Integer>(Arrays.asList(start, i - 1)));
        }

        return result;

    }
}