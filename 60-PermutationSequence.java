import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution60 {
    public String getPermutation(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), n, k);
        return list.get(k - 1).stream().map(m -> String.valueOf(m)).collect(Collectors.joining());
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int n, int k) {

        if (tempList.size() == n) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (list.size() != k) {
            for (int i = 1; i <= n; i++) {
                // if the number used before
                // then pass it
                if (tempList.contains(i))
                    continue;
                tempList.add(i);
                backtrack(list, tempList, n, k);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}