package JianzhiOffer;

import JianzhiOffer.DataSturct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T24FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> resultArr = new ArrayList<>();
        if(root==null) return resultArr;
        dfs(root, target, path, resultArr);
        return resultArr;
    }

    public void dfs(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> resultArr) {
        path.add(root.val);
        if(root.val == target && root.left==null &&root.right==null){
            ArrayList<Integer> temp = new ArrayList<>(path);
            resultArr.add(temp);
        }
        if(root.left!=null) dfs(root.left, target - root.val, path, resultArr);
        if(root.right!=null) dfs(root.right, target-root.val, path, resultArr);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(4);
        T24FindPath findPath = new T24FindPath();
        System.out.println(findPath.FindPath(root, 6));
    }

}
