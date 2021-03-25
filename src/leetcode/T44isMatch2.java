package leetcode;

public class T44isMatch2 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j-1)=='*'){
                dp[0][j] = true;
            }else{
                break;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) != '*') {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (p.charAt(j) == '?') return true;
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        String s="aa",p="*";
        T44isMatch2 t = new T44isMatch2();
        t.isMatch(s,p);
    }
}
