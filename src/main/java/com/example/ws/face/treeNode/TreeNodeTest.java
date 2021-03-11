package com.example.ws.face.treeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class TreeNodeTest {
    private static boolean result = true;
    public static void main(String[] args) {
        new HashSet<>();
        new TreeSet<>();
        new HashMap<>();
    }
    //1树的高度
    public static int maxDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        int length = 0;
        while (root != null){
            length =   Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
        return length;
    }
    //2平衡树
    public static boolean isBalanced(TreeNode root){
        maxDepth1(root);
        return result;
    }
    public static int maxDepth1(TreeNode root){
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(Math.abs(l-r) >1){
            result = false;
        }

        return 1 + Math.max(l, r);
    }

    // 3两节点的最长路径
    private static int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
    //4翻转树
    public static TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);

        return root;

    }
    //5.归并两棵树
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        if(t1 == null && t2 == null){
            return null;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
    //6判断路径和是否等于一个数
    public static boolean hasPathSum(TreeNode root, int sum){
        if(root == null){
            return false;
        }
        if(root.right != null && root.left != null && root.val == sum){
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    //7统计路径和等于一个数的路径数量
    public static int pathSum(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        int ret = pathSumStartWithRoot(root, sum) +  pathSum(root.left,sum) + pathSum(root.right,sum);

        return ret;
    }
    private static int pathSumStartWithRoot(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        int ret = 0;
        if(root.val == sum){
            return ret++;
        }
        ret += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);
        return ret;
    }
    //8子树
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public static boolean isSubtreeWithRoot(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if (t == null || s == null){
            return false;
        }
        if (t.val != s.val) {
            return false;
        }
        return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
    }
    //9树的对称
    public static boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    public static boolean isSymmetric(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        return isSymmetric(t1.left,t2.right) && isSymmetric(t1.right,t2.left);
    }
    // 10最小路径
    public static int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
       if(right == 0 || left == 0){
            return right + left + 1;
       }
       return Math.max(left,right) + 1;
    }

    // 11统计左叶子节点的和
    public static int sumOfLeftLeaves(TreeNode root){
        if(root == null){
            return 0;
        }
        if(isLeaf(root)){
            return root.left.val + sumOfLeftLeaves(root.right);
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

    }
    public static boolean isLeaf(TreeNode node){
        if(node == null){
            return false;
        }
        return node.right == null && node.left == null;

    }
    //12. 相同节点值的最大路径长度
    private static int path = 0;

    public static int longestUnivaluePath(TreeNode root){
        dfs(root);
        return path;

    }
    private static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int rightPath = root.right != null && root.right.val == root.val ? left + 1 : 0;

        path = Math.max(path, leftPath + rightPath);

        return Math.max(leftPath,rightPath);
    }
    //13间隔遍历
    public static int rob(TreeNode root){
        if(root == null){
            return 0;
        }
        int val1 = root.val;
        if(root.left != null){
            val1 += rob(root.left) + rob(root.right);
        }
        if(root.right != null){
            val1 += rob(root.left) + rob(root.right);
        }
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1,val2);
    }
    //14找出二叉树中第二小的节点
    public static int findSecondMinimumValue(TreeNode root){
        if(root == null){
            return -1;
        }
        if(root.left == null && root.left == null){
            return  -1;
        }
        return 0;
    }
}
