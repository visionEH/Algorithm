/**
 *
 */
public class BalancedTree {

    public boolean IsBalanced_Solution(TreeNode root) {
            if(root == null)
                return true;
            int left = depth(root.left);
            int right = depth(root.right);
            int d = dis(left,right);
            return d > 1 ? false : true;
    }


    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);

        return max(left,right) + 1;
    }

    public int max(int a, int b){
        return a > b ? a : b;
    }

    public int dis(int a, int b){
        if (a > b)
            return (a - b);
        else
            return (b - a);
    }


}
