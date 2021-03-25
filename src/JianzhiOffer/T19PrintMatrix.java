package JianzhiOffer;

import java.util.ArrayList;
import java.util.List;

public class T19PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int up = 0, left = 0, right = matrix[0].length-1, bottom = matrix.length-1;
        ArrayList ans = new ArrayList<Integer>();
        while(true){

            for(int i=left;i<=right;i++){
                ans.add(matrix[up][i]);
            }
            up++;
            if(up>bottom){
                break;
            }
            for(int i=up;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--;
            if(left>right){
                break;
            }
            for (int i=right;i>=left;i--){
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            if(up>bottom){
                break;
            }
            for (int i=bottom;i>=up;i--){
                ans.add(matrix[i][left]);
            }
            left++;
            if(left>right) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1},{2},{3},{4},{5}};
        T19PrintMatrix printMatrix = new T19PrintMatrix();
        System.out.println(printMatrix.printMatrix(matrix));
    }
}
