class Solution75 {
    // insertion sort
    public void sortColors(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            int key = nums[i];
            int j = i - 1;

            /*
             * Move elements of nums[0..i-1], that are greater than key, to one position
             * ahead of their current position
             */
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
    }

    // two pass O(m+n) space
    void sortColors2(int A[], int n) {
        int num0 = 0, num1 = 0, num2 = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] == 0)
                ++num0;
            else if (A[i] == 1)
                ++num1;
            else if (A[i] == 2)
                ++num2;
        }

        for (int i = 0; i < num0; ++i)
            A[i] = 0;
        for (int i = 0; i < num1; ++i)
            A[num0 + i] = 1;
        for (int i = 0; i < num2; ++i)
            A[num0 + num1 + i] = 2;
    }

    // one pass in place solution
    void sortColors3(int A[], int n) {
        // n0, n1, n2 represent the last index of 0 (1, 2)
        // everytime it find a '0'
        // all numbers should move 1 position to right
        // everytime it find a '1'
        // n1 and n2 move 1 position to right
        // everytime it find a '1'
        // n2 move 1 position to right
        int n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] == 0) {
                A[++n2] = 2;
                A[++n1] = 1;
                A[++n0] = 0;
            } else if (A[i] == 1) {
                A[++n2] = 2;
                A[++n1] = 1;
            } else if (A[i] == 2) {
                A[++n2] = 2;
            }
        }
    }

    // one pass in place solution
    void sortColors4(int A[], int n) {
        // left is the first index of 1
        // right is th las index of 1
        int left = 0, right = n - 1;
        for (int i = 0; i <= right; i++) {-
            if (A[i] == 0)
                swap(A[i], A[left++]);
            else if (A[i] == 2)
                swap(A[i--], A[right--]);
        }
    }
}