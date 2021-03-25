package leetcode;

/**
 * @Author ：IceSource
 * @Description：
 * @Date ：Created in 2021/3/4 12:08
 * @modified By：
 */
public class T300LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            if(dp[i] > res){
                res = dp[i];
            }
        }
        return res;
    }
}
