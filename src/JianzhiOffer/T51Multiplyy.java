package JianzhiOffer;

/**
 * @Author ：IceSource
 * @Description：
 * @Date ：Created in 2020/12/30 10:58
 * @modified By：
 */
public class T51Multiplyy {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;
        for(int i=1;i<A.length;i++){
            B[i] = B[i-1]*A[i-1];
        }
        int m = 1;
        for(int i=A.length-2;i>=0;i--){
            B[i] = m*A[i+1]*B[i];
            m=m*A[i+1];
        }
        return B;
    }
}
