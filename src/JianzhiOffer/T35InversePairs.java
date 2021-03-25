package JianzhiOffer;

/**
 * @Author ：IceSource
 * @Description：
 * @Date ：Created in 2020/11/21 16:12
 * @modified By：
 */
public class T35InversePairs {
    
    // 暴力破解，时间复杂度超了
    public int InversePairs(int [] array) {
//        int i=0,j=1;
        int result=0;
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]) result++;
            }
        }
        return result;
    }
    
    // 利用递归排序……牛客网解法，很聪明的解法
    public int InversePairs2(int [] array) {
        return Merge_Sort(array, 0, array.length-1);
    }
    
    public int Merge_Sort(int[] array, int i, int j){
        if(i>=j) return 0;
        int ret = 0;
        int mid = i + ((j - i) >> 1);;
        
        ret += Merge_Sort(array,i,mid);
        ret += Merge_Sort(array,mid+1,j);
        ret += _Merge(array,i,mid,j);
        ret %= 1000000007;
        return ret;
    }
    public int _Merge(int[] array, int i, int mid, int j){
        int ret = 0;
        
        int[] tmp = new int[j-i+1];
        int l = i, r=mid+1,k=0;
        while (l<=mid && r<=j){
            if(array[l]<=array[r]){
                tmp[k++] = array[l++];
            }
            else {
                tmp[k++] = array[r++];
                ret += mid-l+1;
                ret %= 1000000007;
            }
        }
        while (l<=mid) tmp[k++] = array[l++];
        while (r<=j) tmp[k++] = array[r++];
        for(k=0;i<=j;i++)
            array[i] = tmp[k++];
        return ret;
    }
    
    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4,5,6,7,0};
        T35InversePairs solution = new T35InversePairs();
        System.out.println(solution.InversePairs2(array));
        
    }
}
