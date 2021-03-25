package leetcode;

public class T5longestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = false;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i + l - 1 < s.length(); i++) {
                int j = i + l - 1;
                if (j - 1 < i + 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j)));
                }
            }
        }
        for (int l = s.length(); l >= 0; l--) {
            for (int i = 0; i + l - 1 < s.length(); i++) {
                int j = i + l - 1;
                if(dp[i][j]){
                    return s.substring(i,j);
                }
            }
        }
        return "";
    }


    // leetcode动态规划解法，写的更漂亮
    public String longestPalindrome2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }


    // 枚举中心扩展方法，回文串的中心必定是长度为1或者2的串，以中心不断向左右两边扩展，到不能扩展为止就是最长回文串
    public String longestPalindrome3(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }


    public static void main(String[] args) {
        String s = "a";
        T5longestPalindrome t5 = new T5longestPalindrome();
        t5.longestPalindrome(s);
    }

}
