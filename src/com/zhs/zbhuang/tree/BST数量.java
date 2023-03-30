package com.zhs.zbhuang.tree;

import java.util.LinkedList;
import java.util.List;

public class BST数量 {
    List<TreeNode>[][] memo;
    public List<TreeNode> generateTrees(int n) {
        memo = (List<TreeNode>[][])new List[n+1][n+1];
        return build(1,n);
    }

    private List<TreeNode> build(int start,int end) {
        //赋予函数一个定义:给一个其实区间,就能搭建出所有的搜索二叉树
        List<TreeNode> res = new LinkedList<>();
        //base case
        if(start>end) {
            res.add(null);
            return res;
        }
        if(memo[start][end]!=null) return memo[start][end];
        //穷举
        for(int i = start;i<=end;i++){
            List<TreeNode> left = build(start,i-1);
            List<TreeNode> right = build(i+1,end);
            for(TreeNode leftTree:left){
                for(TreeNode rightTree:right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }
        memo[start][end]=res;
        return res;
    }

    public static void main(String[] args) {
        List<TreeNode> treeNodes = new BST数量().generateTrees(10);
        System.out.println(treeNodes.size());
        System.out.println(treeNodes);
    }
}
