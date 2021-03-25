package leetcode;

/**
 * @Author ：IceSource
 * @Description：
 * @Date ：Created in 2021/3/3 10:16
 * @modified By：
 */
public class T338CountBits {
    
    public int[] countBits(int num) {
        int[] temp = new int[num+1];
        temp[0] = 0;
        for(int i=1;i<=num;i++){
            if(i%2==0){
                temp[i] = temp[i/2];
            }
            if(i%2==1){
                temp[i] = temp[i-1]+1;
            }
        }
        return temp;
    }
    
}
