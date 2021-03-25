package IntroductionToAlgorithms;

import java.util.HashSet;

/**
 * @Author ：IceSource
 * @Description：八皇后问题,计算八皇后问题的解法数量
 * @Date ：Created in 2020/12/19 11:30
 * @modified By：
 */
public class EightQueens {
    
    private static int sum = 0;
    private static HashSet<Integer> colOccupy = new HashSet<>();
    private static HashSet<Integer> diagonal1Occupy = new HashSet<>();
    private static HashSet<Integer> diagonal2Occupy = new HashSet<>();
    
    public static void dfs(int N, int n){
        for(int i=1;i<=N;i++){
            if(colOccupy.contains(i)){
                continue;
            }else if(diagonal1Occupy.contains(n-i)){
                continue;
            }else if(diagonal2Occupy.contains(i+n)){
                continue;
            }
            if(n==1) {
                sum++;
                return;
            }
            colOccupy.add(i);
            diagonal1Occupy.add(n-i);
            diagonal2Occupy.add(i+n);
            dfs(N,n-1);
            colOccupy.remove(i);
            diagonal1Occupy.remove(n-i);
            diagonal2Occupy.remove(i+n);
        }
    }
    
    public static void main(String[] args) {
        dfs(8,8);
        System.out.println(sum);
    }
    
}
