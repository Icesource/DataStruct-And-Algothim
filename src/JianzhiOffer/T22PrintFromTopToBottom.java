package JianzhiOffer;

import JianzhiOffer.DataSturct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class T22PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            result.add(temp.val);
            if(temp.left != null)queue.offer(temp.left);
            if(temp.right != null)queue.offer(temp.right);
        }
        return result;
    }
}
