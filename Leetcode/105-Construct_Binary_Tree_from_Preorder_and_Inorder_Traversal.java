// Definition for a binary tree node.

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ConstructBinaryTreefromPreorderandInorderTraversal {
    /*
     * For each node in preorder, find same node in inorder and split recursively
     * into left
     * and right subtrees. Bases cases one one element or no elements
     */

    int preorderIndex = 0;
    HashMap<Integer, Integer> inorderValuesToIndicies; // relates node values to their index in inorder array; allows
                                                       // for O(1) search, instead of using a for loop each time

    // time: O(n), space: O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderValuesToIndicies = new HashMap<>();

        // initialize inorderValuesToIndicies
        for (int i = 0; i < inorder.length; i++) {
            inorderValuesToIndicies.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        // base cases
        if (right - left == 1) {
            preorderIndex++;
            return new TreeNode(inorder[left]);
        }
        if (left == right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderIndex]);
        int inorderIndex = inorderValuesToIndicies.get(preorder[preorderIndex]);
        preorderIndex++;

        // divide left of element in inorder into left subtree and right into right
        // subtree
        root.left = buildTreeHelper(preorder, inorder, left, inorderIndex);
        root.right = buildTreeHelper(preorder, inorder, inorderIndex + 1, right);

        return root;
    }
}