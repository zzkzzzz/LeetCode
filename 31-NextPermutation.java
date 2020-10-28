class Solution31 {
    public void nextPermutation(int[] num) {
        int n = num.length;
        if (n < 2)
            return;
        int index = n - 1;
        // example : 2 3 6 5 4 1
        // from right to left, find the first number not increase in a ascending order
        // which will be 3 in the example
        while (index > 0) {
            if (num[index - 1] < num[index])
                break;
            index--;
        }
        // if the index==0 which measing the number is in descending order
        // => 6 5 4 3 2 1, which is the last permutation
        // then we just need to reverse it, return the fisrt permutation
        // => 1 2 3 4 5 6
        if (index == 0) {
            reverseSort(num, 0, n - 1);
            return;
        } else {
            int val = num[index - 1];
            int j = n - 1;
            // try to find the closest number which is larger than val on its right side.
            // in the example 2 3 6 5 4 1, 4 is the closest number that larger than 3
            while (j >= index) {
                if (num[j] > val)
                    break;
                j--;
            }
            // swap them and sort the rest
            swap(num, j, index - 1);
            reverseSort(num, index, n - 1);
            return;
        }
    }

    public void swap(int[] num, int i, int j) {
        int temp = 0;
        temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public void reverseSort(int[] num, int start, int end) {
        if (start > end)
            return;
        for (int i = start; i <= (end + start) / 2; i++)
            swap(num, i, start + end - i);
    }
}
