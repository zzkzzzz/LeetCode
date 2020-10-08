import java.util.ArrayList;
import java.util.List;

class Solution526 {
    int count = 0;

    public int countArrangement(int N) {
        backtrack(new ArrayList<>(), N);
        return count;
    }

    private void backtrack(List<Integer> tempList, int N) {
        if (tempList.size() == N) {
            count++;
        } else {
            for (int i = 1; i <= N; i++) {
                if (tempList.contains(i))
                    continue;
                if (i % (tempList.size() + 1) == 0 || (tempList.size() + 1) % i == 0) {
                    tempList.add(i);
                    backtrack(tempList, N);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}