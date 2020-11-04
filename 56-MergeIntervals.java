import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> res = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i : intervals) {
            // Overlapping intervals, move the end if needed
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                // add the interval
                res.add(new int[] { start, end });
                // init next interval
                start = i[0];
                end = i[1];
            }
        }
        res.add(new int[] { start, end });
        return res.toArray(new int[0][]);

    }
}