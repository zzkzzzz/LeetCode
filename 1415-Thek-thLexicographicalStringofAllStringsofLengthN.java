import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution1415 {
    public String getHappyString(int n, int k) {

        int length = (int) Math.pow(2, n - 1);

        // kth string not exits
        if (length * 3 < k)
            return "";

        return backtrack(Arrays.asList('a', 'b', 'c'), "", length, k, n);
    }

    private String backtrack(List<Character> left, String result, int length, int k, int n) {

        if (n == 0 && k == 0)
            return result;

        char c;
        if (k != 0) {
            if (k % length != 0)
                c = left.get(k / length);
            else
                c = left.get(k / length - 1);
        } else {
            c = left.get(1);
        }

        // append the character
        result = result + c;

        left = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
        // remove the used character
        left.remove(c - 97);

        return backtrack(left, result, length / 2, k % length, n - 1);

    }

}