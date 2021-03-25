package IntroductionToAlgorithms;

/**
 * @Author ：IceSource
 * @Description：矩阵链乘法问题算法代码,动态规划
 */
public class MatrixChainMul {
    
    public static int[][] c;
    public static int[][] s;
    
    public static void matrixChainOrder(int[] p) {
        int n = p.length;
        c = new int[n][n];
        s = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = 0;
                s[i][j] = 0;
            }
        }
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i < n-l+1; i++) {
                int j = i + l -1;
                c[i][j] = 9999999;
                for (int k = i; k < j; k++) {
                    int q = c[i][k]+c[k+1][j]+p[i-1]*p[k]*p[j];
                    if(q<c[i][j]){
                        c[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
    
    public static void display(int[] p, int i, int j){
        if(i==j){
            System.out.print("A"+i);
        }else{
            System.out.print("(");
            display(p,i,s[i][j]);
            display(p,s[i][j]+1,j);
            System.out.print(")");
        }
    }
    
    public static void main(String[] args) {
        int[] p = new int[]{30,35,15,5,10,20,25};
        MatrixChainMul.matrixChainOrder(p);
        MatrixChainMul.display(p,1,6);
    }
    
}
