package JianzhiOffer;

/**
 * @Author ：IceSource
 * @Description：
 * @Date ：Created in 2020/12/29 10:39
 * @modified By：
 */
public class T48Add {
    public int Add(int num1,int num2) {
        int n1 = (num1 & num2)<<1;
        int n2 = (num1 ^ num2);
        while ((n1 & n2) !=0){
            num1=n1;num2=n2;
            n1 = (num1 & num2)<<1;
            n2 = (num1 ^ num2);
        }
        int res = n1 | n2;
        return res;
    }
}
