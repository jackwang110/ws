/*
package com.example.ws.face;

import java.util.LinkedList;

public class Solution {


    public static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data){
            this.value = data;
        }
    }
    */
/**
     *
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     *//*

    */
/**
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *       2
     *.   1.    3
     * 是二叉搜索树
     *       1
     *    2     3
     * 非二叉搜索树
     *
     *思路：中序遍历的结果是从小到大排列，故采用中序遍历，对节点值进行比较，如果出现当前节点值小于前一个节点值则不是二叉搜索树。
     *//*

    //是否是二叉搜索树
    boolean isBstTreeFlg = true;
    //上一个节点值
    int preNodeVal = Integer.MIN_VALUE;

    public boolean[] judgeIt (TreeNode root) {

        boolean[] result = new boolean[2];

        if(root == null){
            result[0] = true;
            result[1] = true;
            return result;
        }

        isBstTree(root);

        result[0] = isBstTreeFlg;

        result[1] = isCompleteTree(root);

        return result;
    }

    //中序遍历
    public void isBstTree(TreeNode root){

        if(root == null || !isBstTreeFlg){
            return;
        }

        isBstTree(root.left);

        if(root.val > preNodeVal){
            preNodeVal = root.val;
        }else{
            //中序遍历 如:2 1 3 2节点 < 1节点 说明不是二叉搜索树 所以直接结束
            isBstTreeFlg = false;
            return;
        }

        isBstTree(root.right);
    }

    public boolean isCompleteTree(TreeNode root){

        if(root == null){
            return false;
        }

        // 1. 先对树进行层序遍历
        // 如果这个标记为 false, 说明还是处在第一阶段
        // 如果这个标记为 true , 接下来的节点就不能有子树
        // 也就是第二阶段开始了
        int flg = 1;//第一阶段:1 第二阶段:2

        LinkedList<TreeNode> queue = new LinkedList();

        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();

            if(flg == 1){

                // 合格的状态, 继续往下遍历.
                // 就把左右子树加入队列就行了
                if(temp.left != null && temp.right != null){
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }else if(temp.left == null && temp.right != null){
                    // 这种情况铁定不是完全二叉树
                    return false;
                }else if(temp.left != null && temp.right == null){
                    // 这是临界状态, 开启第二阶段
                    queue.offer(temp.left);
                    //开启第二阶段
                    flg = 2;
                }else{
                    // 左右子树都为空, 开启第二阶段
                    flg = 2;
                }
            }else{
                //开启第二阶段
                // 第二阶段要求节点必须没有子树. 只要子树存在, 就不是完全二叉树
                if(temp.left != null || temp.right != null){
                    return false;
                }
            }
        }

        return true;
    }

}
*/
