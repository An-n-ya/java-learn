package java_vscode.HelloWorld.src.BinaryTree;

// import java_vscode.HelloWorld.src.BinaryTree.Traverse;
import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    };

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public String toString() {
        return String.valueOf(val);
    }

    public static void main(String[] args) {
        TreeNode q = TreeNodeUtil.arrayToTreeNode(new Integer[] { 13, 2, 14, 1, 10, null, 18 });
        TreeNodeShow.show(q);

        // traverse test
        // System.out.print("recursive:");
        // Traverse.recursiveOrder(q);
        // System.out.println();
        // System.out.print("first:");
        // Traverse.firstOrder(q);
        // System.out.println();
        // System.out.print("first nonrecursive:");
        // Traverse.firstOrderNonRecursive(q);
        // System.out.println();
        // System.out.print("midlle:");
        // Traverse.middleOrder(q);
        // System.out.println();
        // System.out.print("middle nonrecursive:");
        // Traverse.middleOrderNonRecursive(q);
        // System.out.println();
        // System.out.print("last:");
        // Traverse.lastOrder(q);
        // System.out.println();
        // System.out.print("last nonrecursive:");
        // Traverse.lastOrderNonRecursive(q);
        // System.out.println();
        // System.out.print("width recursive:");
        // Traverse.widthRecur(q);
        // System.out.println();
        // System.out.print("max width: ");
        // Traverse.maxWidth(q);
        // System.out.println();

        // tree DP
        // System.out.print("isBST:");
        // System.out.println(CheckSet.isSearchBinaryTree(q).isBST);

        // TreeNode t1 = q.right;
        // TreeNode t2 = q.right.right;
        // System.out.print("the t1 is: " + t1 + " ,");
        // System.out.print("the t2 is: " + t2 + " ,");
        // System.out.print("the LCA is: " + CheckSet.LCANode(q, t1, t2));

        // tree serialization
        Integer[] arr = TreeNodeUtil.treeNodeToArray(q);
        System.out.println(Arrays.toString(arr));
    }
}
