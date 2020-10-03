
import java.util.ArrayList;
import java.util.List;

class Solution17 {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if (digits.length() == 0)
            return result;
        String temp = "";

        // initialize the letter map
        String[][] letterMap = new String[10][4];
        letterMap[2] = new String[] { "a", "b", "c" };
        letterMap[3] = new String[] { "d", "e", "f" };
        letterMap[4] = new String[] { "g", "h", "i" };
        letterMap[5] = new String[] { "j", "k", "l" };
        letterMap[6] = new String[] { "m", "n", "o" };
        letterMap[7] = new String[] { "p", "q", "r", "s" };
        letterMap[8] = new String[] { "t", "u", "v" };
        letterMap[9] = new String[] { "w", "x", "y", "z" };

        backtrack(result, temp, letterMap, digits, 0);

        return result;
    }

    private void backtrack(ArrayList<String> result, String temp, String[][] letterMap, String digits, int start) {
        if (temp.length() == digits.length()) {
            result.add(temp);
        } else {
            // convert the char digit to int digit
            int num = digits.charAt(start) - '0';
            // the array size can be 3 or 4 depending on the num
            for (int i = 0; i < letterMap[num].length; i++) {
                // concat a new letter under current digit to the end of the string
                temp = temp.concat(letterMap[num][i]);
                backtrack(result, temp, letterMap, digits, start + 1);
                // remove the last letter from the string
                temp = temp.substring(0, temp.length() - 1);
            }
        }

    }
}