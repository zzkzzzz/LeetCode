import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution1079 {
    // simialr to PermutationsII
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        List<List<Character>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), chars, new boolean[chars.length]);
        return list.size();
    }

    // extra space used=>list
    private void backtrack(List<List<Character>> list, List<Character> tempList, char[] chars, boolean[] used) {
        if (!tempList.isEmpty())
            list.add(new ArrayList<>(tempList));
        for (int i = 0; i < chars.length; i++) {
            // if current character was used before
            // OR
            // previous character is equals to current character
            // and used before
            // These two conditions will result in repeated premutations
            if (used[i] || i > 0 && chars[i] == chars[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            tempList.add(chars[i]);
            backtrack(list, tempList, chars, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    // Solution2
    // no extra space used
    int count = 0;

    public int numTilePossibilities2(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        backtrack2(chars, new boolean[chars.length]);
        // remove the empty one
        return count - 1;
    }

    private void backtrack2(char[] chars, boolean[] used) {
        count = count + 1;
        for (int i = 0; i < chars.length; i++) {
            // if current character was used before
            // OR
            // previous character is equals to current character
            // and the previous character is not used before
            // These two conditions will result in repeated permutations
            if (used[i] || i > 0 && chars[i] == chars[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            backtrack2(chars, used);
            used[i] = false;
        }
    }
}