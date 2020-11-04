import java.util.Arrays;

class Solution435 {
    // greedy
    // {all intervals} - {max compatible intervals} = minimum deleted intervals
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1)
            return 0;
        // Sort by ascending ending point
        // Which interval would be the best first (leftmost) interval to keep? One that
        // ends first, as it leaves the most room for the rest.
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1], i2[1]));

        int count = 1;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;

    }
}