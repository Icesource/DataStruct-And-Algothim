package JianzhiOffer;

public class T10RectCover {
    public int RectCover(int target) {
        if(target==1) return 1;
        if(target==2) return 2;
        int a=1,b=2,c=0;
        for(int i=3;i<=target;i++){
            c = a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
