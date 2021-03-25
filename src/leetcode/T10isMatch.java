package leetcode;

public class T10isMatch {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1) != '*') {
                    if(matches(s,p,i,j)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (!matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j-1) == '.') {
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        T10isMatch t = new T10isMatch();
        t.isMatch(s,p);
    }

}
