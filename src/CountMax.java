/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 */
public class CountMax {



    public int TreeDepth(TreeNode root) {
               if(root == null)
                   return 0;
               return depth(root);
    }

    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);

        return min(left,right) + 1;
    }

    public int min(int a, int b){
        return a > b ? a : b;
    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
