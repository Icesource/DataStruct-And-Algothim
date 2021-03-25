package JianzhiOffer;

public class T7Fibonacci {
    // 递归方法，我第一时间想到的是这种方法
    public int Fibonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    // 迭代方法，时间效率比递归高很多，用两个数来保存中间结果即可
    public int Fibonacci2(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        int numfn1 = 0, numfn2 = 1;
        int currentnum = 0;
        for(int i=2; i<=n; ++i) {
            currentnum = numfn1+numfn2;
            numfn1 = numfn2;
            numfn2 = currentnum;
        }
        return currentnum;
    }

    // 另一种迭代写法，牛客网上最优雅简洁的写法（动态规划？）
    int Fibonacci3(int n) {
        int f = 0, g = 1;
        while(n-->=0) {
            g += f;
            f = g - f;
        }
        return f;
    }
}