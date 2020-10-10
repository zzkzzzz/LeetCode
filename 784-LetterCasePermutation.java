import java.util.ArrayList;
import java.util.List;

class Solution784 {
    public List<String> letterCasePermutation(String S) {
        char[] list = S.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        backtrack(result, list, 0);
        return result;
    }

    private void backtrack(List<String> result, char[] list, int start) {

        if (start == list.length) {
            result.add(new String(list));
            return;
        }

        if (Character.isLetter(list[start])) {
            list[start] = Character.toLowerCase(list[start]);
            backtrack(result, list, start + 1);
            list[start] = Character.toUpperCase(list[start]);
            backtrack(result, list, start + 1);

        } else {
            backtrack(result, list, start + 1);
        }

    }

    private void backtrack(List<String> result, String temp, char[] list, int start) {

        for (int i = start; i <= list.length; i++) {
            if (temp.length() == list.length) {
                result.add(temp);
                return;
            }
            if (Character.isLetter(list[i])) {
                temp = temp.concat(Character.toLowerCase(list[i]) + "");
                backtrack(result, temp, list, i + 1);
                temp = temp.substring(0, temp.length() - 1);
                temp = temp.concat(Character.toUpperCase(list[i]) + "");

            } else {
                temp = temp.concat(list[i] + "");
            }

        }

    }
}