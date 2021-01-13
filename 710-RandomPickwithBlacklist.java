import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    int M;
    Random r;
    Map<Integer, Integer> map;

    public Solution(int N, int[] blacklist) {
        map = new HashMap<>();
        // put all items of blacklist in hashmap
        for (int b : blacklist) // O(B)
            map.put(b, -1);

        // [0,M) are the items we need
        // [M,N) are blacklist item
        M = N - map.size();

        // move all blacklist items to [M,N)
        int last = N - 1;
        for (int b : blacklist) {
            // if the item is already between [M,N) then just skip
            if (b < M) {
                while (map.containsKey(last))
                    last--;
                map.put(b, last);
                last--;
            }
        }

        r = new Random();
    }

    public int pick() {
        int p = r.nextInt(M);
        if (map.containsKey(p))
            return map.get(p);
        return p;
    }
}