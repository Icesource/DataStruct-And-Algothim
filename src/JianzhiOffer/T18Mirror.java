package JianzhiOffer;

import JianzhiOffer.DataSturct.TreeNode;

public class T18Mirror {
    // 先序遍历的递归版本
    public void Mirror(TreeNode root) {
        if(root!=null){
            if(root.left!=null||root.right!=null){
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
                Mirror(root.left);
                Mirror(root.right);
            }
        }
    }

    // 写的好看一点的递归版本，后序遍历
    TreeNode dfs(TreeNode r) {
        if (r==null) return null;
        TreeNode lval = dfs(r.left);
        TreeNode rval = dfs(r.right);
        r.left = rval; r.right = lval;
        return r;
    }
    void Mirror2(TreeNode pRoot) {
        if (pRoot==null) return;
        dfs(pRoot);
    }

    // 还有非递归的广度优先遍历的解法（层次遍历）
}
