package JianzhiOffer;

public class T28MoreThanHalfNumSolution {
    public int MoreThanHalfNum_Solution(int [] array) {

        int flagNum = -1;
        int count = 0;

        for(int i=0;i<array.length;i++){
            if(count==0){
                flagNum = array[i];
                ++count;
            }else{
                if(array[i]==flagNum) ++count;
                else --count;
            }
        }
        count = 0;
        for(int i=0;i<array.length;i++){
            if(flagNum==array[i]) count++;
        }
        if(count>array.length/2) return flagNum;
        else return 0;

    }
}
