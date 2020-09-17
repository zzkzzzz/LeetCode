class Solution64447 {
    // Subproblem
    // In a char array n[], if we have n(j) == n(i) (j<i)
    // then from n(j) to n(i),
    // its possible to be a Palindromic substring if matches any condition below
    // if i-j<=2, there only have 0 or 1 characters between n[j] and n[i]
    // examples: aba, cac, aa, cc
    // OR dp[j + 1][i - 1] == true,
    // the substring from n(j+1) to n(i-1) is a Palindromic string
    // example: abba, acbca, aaaa
    public int countSubstrings(String s) {
        int size = s.length();
        // dp[j][i] => whether substring from n(j) to n(i) is Palindromic string or not
        boolean[][] dp = new boolean[size][size];
        // the character itself is a Palindromic substring
        // example: a,b,c
        int sum = size;
        for (int i = 0; i < size; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (i - j <= 2 || dp[j + 1][i - 1] == true) {
                        dp[j][i] = true;
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}