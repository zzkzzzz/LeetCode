import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution403 {
    // dp iterative top-down solution
    // subproblem = stand on a stone, the stone can jump to = stone + {k1,k2,k3...}.
    // if the the newstone=stone+k1 exists,
    // then the next stone that newstone can jump to are
    // newstone+k1-1,newstone+k1 ,newstone+k1+1
    // keep doing this, until newstone+k equals the last stone
    //
    // why use Hashmap?
    // easy to get all k values by using map.get(stone)
    // why use HaspSet?
    // prevent repeated k values
    public boolean canCross(int[] stones) {
        if (stones.length == 0) {
            return true;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }

        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int k : map.get(stone)) {
                // the newstone can reach to
                int newstone = k + stone;
                // check newstone reach to last stone or not
                if (newstone == stones[stones.length - 1]) {
                    return true;
                }
                // get the new stone
                HashSet<Integer> set = map.get(newstone);
                // if the new stone exist
                // new steps this frog can jump to
                if (set != null) {
                    // add k-1, k, k+1 into set
                    set.add(k);
                    if (k - 1 > 0)
                        set.add(k - 1);
                    set.add(k + 1);
                }
            }
        }

        return false;
    }

    // dp recursive solution
    public boolean canCross2(int[] stones) {
        if (stones[1] != 1)
            return false;

        Set<Integer> units = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            if (i > 0 && stones[i] - stones[i - 1] > i)
                return false;
            units.add(stones[i]);
        }
        return cross(units, 1, 1, stones[stones.length - 1]);
    }

    private boolean cross(Set<Integer> units, int newstone, int k, int destination) {
        // k - 1 < 0
        if (k <= 0)
            return false;
        // check newstone is exist in the stones set or not
        if (!units.contains(newstone))
            return false;
        // check newstone reach to last stone or not
        if (newstone == destination)
            return true;

        // if haven't reach to destination and the new stone is exist
        // then start from new stone with new k (k+1,k,k-1)
        return cross(units, newstone + k + 1, k + 1, destination) || cross(units, newstone + k, k, destination)
                || cross(units, newstone + k - 1, k - 1, destination);
    }

}
