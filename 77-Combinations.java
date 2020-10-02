import java.util.ArrayList;
import java.util.List;

class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), n, k);
        return result;

    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int n, int k) {
        if (tempList.size() == k)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = n; i > 0; i--) {
                tempList.add(i);
                backtrack(list, tempList, i - 1, k);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}