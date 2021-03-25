package JianzhiOffer;

/**
 * @Author ：IceSource
 * @Description：
 * @Date ：Created in 2020/11/18 14:18
 * @modified By：
 */
public class T33GetUglyNumber {
    
    /**
     * 这是牛客网题解，丑数能够分解成2^x3^y5^z,
     * 所以只需要把得到的丑数不断地乘以2、3、5之后并放入他们应该放置的位置即可
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0)return 0;
        int p2=0,p3=0,p5=0;//初始化三个指向三个潜在成为最小丑数的位置
        int[] result = new int[index];
        result[0] = 1;//
        for(int i=1; i < index; i++){
            result[i] = Math.min(result[p2]*2, Math.min(result[p3]*3, result[p5]*5));
            if(result[i] == result[p2]*2)p2++;//为了防止重复需要三个if都能够走到
            if(result[i] == result[p3]*3)p3++;//为了防止重复需要三个if都能够走到
            if(result[i] == result[p5]*5)p5++;//为了防止重复需要三个if都能够走到
        
        
        }
        return result[index-1];
    }
    
}
