package leetcode;

public class T32longestValidParentheses {
    public int longestValidParentheses(String s) {
        int ret = 0;
        int n = s.length();
        int[] dp = new int[s.length()];
//        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
            } else if (s.charAt(i) == ')' && s.charAt(i - 1) == ')') {
                if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >=0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        T32longestValidParentheses t = new T32longestValidParentheses();
        t.longestValidParentheses(")()())");
    }
}
