class Solution66 {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // for array that contians only '9'
        // '9999' -> '10000'
        // the default value of array is 0
        // only need to set the first digit
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    // it will exits the int range
    public int[] plusOne2(int[] digits) {
        int result = 0;
        int count = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int time = digits[i] * (int) Math.pow(10, count++);
            result = result + time;
        }
        String temp = Integer.toString(result + 1);

        int[] array = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            array[i] = temp.charAt(i) - '0';
        }

        return array;
    }

    public static void main(String[] args) {
        Solution66 solution = new Solution66();
        int[] a = solution.plusOne2(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 });
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i]);
    }
}