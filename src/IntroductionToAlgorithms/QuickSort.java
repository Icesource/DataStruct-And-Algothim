package IntroductionToAlgorithms;

/**
 * @Author ：IceSource
 * @Description：快排
 */
public class QuickSort {
    
    public static int quickSort(int[] l, int i, int j) {
        int temp = l[i];
        while (i < j) {
            while (i < j && l[j] > temp) j--;
            if (i < j) {
                l[i++] = l[j];
            }
            while (i < j && l[i] < temp) i++;
            if (i < j) {
                l[j--] = l[i];
            }
        }
        l[i] = temp;
        return i;
    }
    
    public static void sort(int[] list, int i, int j) {
        if(i<j){
            int m = quickSort(list, i,j);
            quickSort(list,0,m);
            quickSort(list,m+1,j);
        }
    }
    
    public static void main(String[] args) {
        int[] testList = new int[]{5, 3, 7, 9, 4};
        QuickSort.sort(testList,0, testList.length-1);
        for(int i=0;i<testList.length;i++){
            System.out.print(testList[i]);
        }
    }
    
}
