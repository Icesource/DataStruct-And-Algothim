package JianzhiOffer;

public class T9JumpFloorII {

    public static int JumpFloorII(int target) {
        if(target==1)
            return 1;
        if(target==2)
            return 2;
        int sum = 0;
        for(int i=1;i<target;i++){
            sum += JumpFloorII(i);
        }
        sum += 1;
        return sum;
    }
    
    public static void main(String[] args) {
//        System.out.println(T9JumpFloorII);
    }
}
