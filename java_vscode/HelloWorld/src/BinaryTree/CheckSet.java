package java_vscode.HelloWorld.src.BinaryTree;

public class CheckSet {
    public static class SBTReturn {
        public boolean isBST;
        public int max;
        public int min;

        public SBTReturn(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static SBTReturn isSearchBinaryTree(TreeNode tree) {
        if (tree == null) {
            return new SBTReturn(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        SBTReturn leftReturn = isSearchBinaryTree(tree.left);
        SBTReturn rightReturn = isSearchBinaryTree(tree.right);

        int min;
        int max;
        if (tree.left == null) {
            min = tree.val;
        } else {
            min = Math.min(leftReturn.min, tree.val);
        }
        if (tree.right == null) {
            max = tree.val;
        } else {
            max = Math.max(rightReturn.max, tree.val);
        }
        boolean res = true;
        if (tree.left != null && (leftReturn.isBST == false || leftReturn.max >= tree.val)) {
            res = false;
        }
        if (tree.right != null && (rightReturn.isBST == false || rightReturn.min <= tree.val)) {
            res = false;
        }

        return new SBTReturn(res, max, min);
    }

    // least common ancestor
    public static TreeNode LCANode(TreeNode tree, TreeNode t1, TreeNode t2) {
        if (tree == null || tree == t1 || tree == t2) {
            return tree;
        }
        TreeNode leftRes = LCANode(tree.left, t1, t2);
        TreeNode rightRes = LCANode(tree.right, t1, t2);
        if (leftRes == null && rightRes == null) {
            return null;
        } else if (leftRes != null && rightRes != null) {
            return tree;
        } else {
            return leftRes != null ? leftRes : rightRes;
        }
    }
}
