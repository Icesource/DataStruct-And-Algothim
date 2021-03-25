package JianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class T29GetLeastNumbers {
    
    // 借着这个题的机会把主要排序算法全部手写一遍
    
    // 快速排序
    public void GetLeastNumbers_Solution_QuickSort(int[] input, int l, int r) {
        if (l < r) {
            int flag = input[l], i = l, j = r;
            while (i < j) {
                while (input[j] >= flag && j > i) j--;
                if (j > i) input[i++] = input[j];
                while (input[i] <= flag && i < j) i++;
                if (i < j) input[j--] = input[i];
            }
            input[i] = flag;
            GetLeastNumbers_Solution_QuickSort(input, l, i - 1);
            GetLeastNumbers_Solution_QuickSort(input, i + 1, r);
            
        }
    }
    
    // 归并排序
    public void GetLeastNumbers_Solution_MergeSort(int[] input, int left, int right) {
        if (left < right) {
            // 递归的逻辑
            int mid = (left + right) / 2;
            GetLeastNumbers_Solution_MergeSort(input, left, mid);
            GetLeastNumbers_Solution_MergeSort(input, mid + 1, right);
            
            // 排序的逻辑
            int arr[] = new int[input.length];
            int t = 0, i = left, j = mid + 1;
            while (i <= mid && j <= right) {
                if (input[i] <= input[j]) arr[t++] = input[i++];
                else arr[t++] = input[j++];
            }
            
            while (i <= mid) arr[t++] = input[i++];
            while (j <= right) arr[t++] = input[j++];
            for (int m = left; m <= right; m++) {
                input[m] = arr[m - left];
            }
        }
    }
    
    
    public void GetLeastNumbers_Solution_HeapSort(int[] input, int left, int right) {
        for (int i = input.length / 2 - 1; i >= 0; i--) {
            adjustHeap(input, i, input.length);
        }
    }
    
    public static void main(String[] args) {
        T29GetLeastNumbers getLeastNumbers = new T29GetLeastNumbers();
        int test[] = {4, 5, 1, 6, 2, 7, 3, 8, 15, 30, 88, 123, 11, 57};
        
        // 快排
        long start = System.currentTimeMillis();
        getLeastNumbers.GetLeastNumbers_Solution_QuickSort(test, 0, test.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("快速排序，耗时：" + (end - start));
        for (int temp : test) {
            System.out.print(temp + " ");
        }
        System.out.println();
        
        
        // 归并
        start = System.currentTimeMillis();
        int test2[] = {4, 5, 1, 6, 2, 7, 3, 8, 15, 30, 88, 123, 11, 57};
        getLeastNumbers.GetLeastNumbers_Solution_MergeSort(test2, 0, test.length - 1);
        end = System.currentTimeMillis();
        System.out.println("归并排序，耗时：" + (end - start));
        for (int temp : test2) {
            System.out.print(temp + " ");
        }
        System.out.println();
        
        
        // 堆排序
        start = System.currentTimeMillis();
        int test3[] = {4, 5, 1, 6, 2, 7, 3, 8};
        getLeastNumbers.GetLeastNumbers_Solution_HeapSort(test3, 0, test.length - 1);
        end = System.currentTimeMillis();
        System.out.println("堆排序，耗时：" + (end - start));
        for (int temp : test3) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }
    
    public void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] > arr[k + 1]) k = k + 1;
            if(temp > arr[k]){
                arr[i]=arr[k];
                i=k;
            }else{
                break;
            }
        }
        arr[i] = temp;
    }
}
