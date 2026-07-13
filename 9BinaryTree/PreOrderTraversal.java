/*
二叉树的前序遍历

示例 1：

输入：root = [1,null,2,3]
输出：[1,2,3]

示例 2：

输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]
输出：[1,2,4,5,6,7,3,8,9]

示例 3：

输入：root = []
输出：[]

示例 4：

输入：root = [1]
输出：[1]
提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100
*/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }
    public void preorder(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }
}