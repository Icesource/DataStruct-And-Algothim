package JianzhiOffer;

public class T13reOrderArray {
    public void reOrderArray(int [] array) {
        int i = 0;
        for (int j=0; j<array.length; ++j) {
            if ((array[j]&1)!=0) {
                int tmp = array[j];
                for (int k=j-1; k>=i; --k) {
                    array[k+1] = array[k];
                }
                array[i++] = tmp;
            }
        }
    }
}
