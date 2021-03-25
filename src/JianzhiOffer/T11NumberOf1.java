package JianzhiOffer;

public class T11NumberOf1 {
    public int NumberOf1(int n) {
        int ans=0;
        int mark=0x01;
        while(mark!=0){
            if((mark & n) !=0) ans++;
            mark = mark << 1;
        }
        return ans;
    }
    public int NumberOf1II(int n) {
        int ans=0;
        while(n!=0){
            ++ans;
            n = n&(n-1);
        }
        return ans;
    }
}
