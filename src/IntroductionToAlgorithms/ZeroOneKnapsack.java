package IntroductionToAlgorithms;

/**
 * @Author ：IceSource
 * @Description：0-1背包问题，动态规划解法
 */
public class ZeroOneKnapsack {
    
    private static int[][] w;
    
    private static int[] item = new int[]{};
    
    private static int[] V = new int[]{3, 4, 5, 6};
    private static int[] W = new int[]{2, 3, 4, 5};
    
    
    /**
     * 递归查找最优解的组成情况
     * 1) w(i,j)=w(i-1,j)时，说明没有选择第i个商品
     * 2) w(i,j)=w(i-1,j-W(i))+V(i)实时，说明装了第i个商品
     */
    public static void FindWhat(int i, int j) {
        int chosenIndex = i - 1;
        if (i > 0) {
            if (w[i][j] == w[i - 1][j]) {
                item[chosenIndex] = 0;
                FindWhat(i - 1, j);
            } else if (j - W[chosenIndex] >= 0 && w[i][j] == w[i - 1][j - W[chosenIndex]] + V[chosenIndex]) {
                item[chosenIndex] = 1;
                FindWhat(i - 1, j - W[chosenIndex]);
            }
        }
    }
    
    
    /**
     * @param c 背包容量
     * @param V 价值数组
     * @param W 重量数组
     */
    public static void solution(int[] V, int[] W, int c) {
        item = new int[W.length];
        w = new int[W.length + 1][c + 1];
        for (int i = 0; i <= W.length; i++) {
            for (int j = 0; j <= c; j++) {
                w[i][j] = 0;
            }
        }
        for (int i = 1; i <= W.length; i++) {
            int chosenItem = i - 1;
            for (int j = 0; j <= c; j++) {
                if (W[chosenItem] > j) {
                    w[i][j] = w[i - 1][j];
                } else {
                    w[i][j] = Math.max(w[i - 1][j], w[i - 1][j - W[chosenItem]] + V[chosenItem]);
                }
            }
        }
        FindWhat(W.length, c);
    }
    
    public static void main(String[] args) {
        ZeroOneKnapsack.solution(V, W, 8);
        System.out.print("选择第");
        for (int i = 0; i < item.length; i++) {
            if (item[i] == 1) {
                System.out.print(" " + i + " ");
            }
        }
        System.out.println("件商品价值最大");
    }
    
    
}
