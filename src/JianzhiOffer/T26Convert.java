package JianzhiOffer;

import JianzhiOffer.DataSturct.TreeNode;

import java.util.Stack;

public class T26Convert {

    public TreeNode PreOrder(TreeNode root){
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p!=null||!stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                System.out.println(p.val);
                p = p.left;
            }else{
                p = stack.pop();
                p = p.right;
            }
        }
        return root;
    }

    // 二叉树的非递归中序遍历
    public TreeNode InOder(TreeNode pRootOfTree) {
        TreeNode p = pRootOfTree;
        Stack<TreeNode> stack = new Stack<>();
        while(p!=null || !stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                System.out.println(p.val);
                p = p.right;
            }
        }
//        BST(root);
        return pRootOfTree;
    }

    /**
     * //非递归后序遍历
     * typedef struct BiTNodePost{
     *     BiTree biTree;
     *     char tag;
     * }BiTNodePost, *BiTreePost;
     *
     * void PostOrder(BiTree T)
     * {
     *     stack<BiTreePost> stack;
     *     //p是遍历指针
     *     BiTree p = T;
     *     BiTreePost BT;
     *     //栈不空或者p不空时循环
     *     while (p != NULL || !stack.empty())
     *         {
     *         //遍历左子树
     *         while (p != NULL)
     *                {
     *             BT = (BiTreePost)malloc(sizeof(BiTNodePost));
     *             BT->biTree = p;
     *             //访问过左子树
     *             BT->tag = 'L';
     *             stack.push(BT);
     *             p = p->lchild;
     *         }
     *         //左右子树访问完毕访问根节点
     *         while (!stack.empty() && (stack.top())->tag == 'R')
     *                 {
     *             BT = stack.top();
     *             //退栈
     *             stack.pop();
     *             p=BT->biTree;
     *             cout<<BT->biTree->data<<" ";
     *         }
     *         //遍历右子树
     *         if (!stack.empty())
     *                 {
     *             BT = stack.top();
     *             //访问过右子树
     *             BT->tag = 'R';
     *             p = BT->biTree;
     *             p = p->rchild;
     *         }
     *     }
     * }
     *
     */

    // 最简单的解法就是递归中序遍历一遍这个搜索二叉树，用数组记录下来遍历的节点，然后遍历这个数组修改节点……
    public void BST(TreeNode treeNode){
        if(treeNode == null) return;
        BST(treeNode.left);
        System.out.println(treeNode.val);
        BST(treeNode.right);
    }

    // 基于非递归中序遍历的解题方法
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        TreeNode p = pRootOfTree;
        Stack<TreeNode> stack = new Stack<>();
        boolean isFirst = true;
        TreeNode pre = null;

        while (p!=null || !stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                System.out.println(p.val);
                if(isFirst){
                    pRootOfTree = p;
                    pre = pRootOfTree;
                    isFirst = false;
                }else{
                    pre.right = p;
                    p.left = pre;
                    pre = p;
                }
                p = p.right;
            }
        }
        return pRootOfTree;
    }

    // 递归的解题方法，很巧妙的想法
    public TreeNode Convert2(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while(p!=null&&p.right!=null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(29);

        T26Convert convert = new T26Convert();
        convert.Convert(root);
    }

}
