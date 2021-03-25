package JianzhiOffer;

public class T23VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0) return false;
        return isBST(sequence,0,sequence.length-1);
    }

    public boolean isBST(int[] sequence, int start, int end){
        if(start>=end) return true;
        int i=start;
        int rootIndex = end;
        for(;i<end;i++){
            if(sequence[i]>sequence[rootIndex]) break;
        }
        for(int j=i;j<end;j++){
            if (sequence[j] < sequence[rootIndex]) return false;
        }
        return isBST(sequence, i, end-1) && isBST(sequence, start,i-1);
    }

    public static void main(String[] args) {
        T23VerifySquenceOfBST t23VerifySquenceOfBST = new T23VerifySquenceOfBST();
        int[] a = {1,2,4,7,5,3};
        System.out.println(t23VerifySquenceOfBST.VerifySquenceOfBST(a));
    }

}
