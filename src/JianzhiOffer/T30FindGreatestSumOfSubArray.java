package JianzhiOffer;

public class T30FindGreatestSumOfSubArray {
    
    
    // 动态规划解法
    public int FindGreatestSumOfSubArray(int[] array) {
        // dp[i]表示以第i个元素结尾的最大子数组的和
        int dp[] = new int[array.length+1];
        dp[0] = 0;
        int result = array[0];
        for(int i=1;i<=array.length;i++){
            dp[i] = Math.max(dp[i-1] + array[i-1], array[i-1]);
            if(dp[i]>result) result = dp[i];
        }
        
        return result;
    }
    
    // 解法2，空间复杂度为O（1）的解法我不是十分理解，牛客官方题解里
    
    public static void main(String[] args) {
        T30FindGreatestSumOfSubArray t30FindGreatestSumOfSubArray = new T30FindGreatestSumOfSubArray();
        int[] test = new int[]{1,-2,3,10,-4,7,2,-5};
        t30FindGreatestSumOfSubArray.FindGreatestSumOfSubArray(test);
    }
    
    
}
