package leetcode;

/**
 * @Author ：IceSource
 * @Description：
 * @Date ：Created in 2021/3/2 22:30
 * @modified By：
 */
public class T304NumMatrix {
    
    private int[][] sums;
    
    // 一维前缀和的形式，但是查找还是要消耗O（m）的时间
//    public T304NumMatrix(int[][] matrix) {
//        int m = matrix.length;
//        if(m>0){
//            int n = matrix[0].length;
//            sums = new int[m][n+1];
//            for(int i=0;i<m;i++){
//                for(int j=0;j<n;j++){
//                    sums[i][j+1] = sums[i][j] + matrix[i][j];
//                }
//            }
//        }
//    }
//
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sums[i][col2 + 1] - sums[i][col1];
        }
        return sum;
    }
    
    // 二维前缀和
    public T304NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion2(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    
    }
}
