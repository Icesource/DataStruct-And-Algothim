package JianzhiOffer;

import JianzhiOffer.DataSturct.TreeNode;

public class T17HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1==null ||root2 == null) return false;
        return judgeSubTree(root1,root2)||judgeSubTree(root1.left,root2)||judgeSubTree(root1.right,root2);
    }

    public boolean judgeSubTree(TreeNode root1, TreeNode root2){
        if(root2==null) return true;
        else if (root1==null) return false;
        else{
            return root1.val==root2.val && judgeSubTree(root1.left,root2.left)&&judgeSubTree(root1.right,root2.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);
        T17HasSubtree hasSubtree = new T17HasSubtree();
        boolean ans = hasSubtree.HasSubtree(root,root2);
    }
}
