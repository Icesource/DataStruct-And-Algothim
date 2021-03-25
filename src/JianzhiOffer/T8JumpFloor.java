package JianzhiOffer;

public class T8JumpFloor {

    // 递归写法
    public static int JumpFloor(int target) {
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        return JumpFloor(target-1)+ JumpFloor(target-2);
    }

    public static int JumpFloor2(int target) {
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int fn1=1,fn2=2;
        int fn3=0;
        for(int i=3;i<target;i++){
            // 动态规划思路，划分子问题
            fn3 = fn1 + fn2 + 3;
            fn1 = fn2;
            fn2 = fn3;
        }
        return JumpFloor(target-1)+ JumpFloor(target-2);
    }
    
    public static void main(String[] args) {
        System.out.println(T8JumpFloor.JumpFloor(5));
    }

}