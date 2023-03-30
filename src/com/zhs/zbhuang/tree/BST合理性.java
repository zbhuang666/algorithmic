package com.zhs.zbhuang.tree;

public class BST合理性 {
    boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        String data = "10,5,#,#,15,6,#,#,20,#,#";
        TreeNode treeNode = new 二叉树序列化与反序列化().deserialize(data);
        boolean validBST = new BST合理性().isValidBST(treeNode);
        System.out.println(validBST);
    }
}
