package java_vscode.HelloWorld.src.BinaryTree;

import java.util.*;

public class Traverse {
    public static void recursiveOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.print(tree.val + " ");
        recursiveOrder(tree.left);
        System.out.print(tree.val + " ");
        recursiveOrder(tree.right);
        System.out.print(tree.val + " ");
    }

    public static void firstOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.print(tree.val + " ");
        firstOrder(tree.left);
        firstOrder(tree.right);
    }

    public static void firstOrderNonRecursive(TreeNode tree) {
        if (tree == null) {
            return;
        }
        var stack = new LinkedList<TreeNode>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            TreeNode e = stack.pop();
            System.out.print(e.val + " ");
            if (e.right != null) {
                stack.push(e.right);
            }
            if (e.left != null) {
                stack.push(e.left);
            }
        }

    }

    public static void middleOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        middleOrder(tree.left);
        System.out.print(tree.val + " ");
        middleOrder(tree.right);
    }

    public static void middleOrderNonRecursive(TreeNode tree) {
        if (tree == null) {
            return;
        }
        var stack = new LinkedList<TreeNode>();
        while (!stack.isEmpty() || tree != null) {
            if (tree != null) {
                stack.push(tree);
                tree = tree.left;
            } else {
                tree = stack.pop();
                System.out.print(tree.val + " ");
                tree = tree.right;
            }
        }
    }

    public static void lastOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        lastOrder(tree.left);
        lastOrder(tree.right);
        System.out.print(tree.val + " ");
    }

    public static void lastOrderNonRecursive(TreeNode tree) {
        if (tree == null) {
            return;
        }
        var stack = new LinkedList<TreeNode>();
        var stack2 = new LinkedList<TreeNode>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            var head = stack.pop();
            stack2.push(head);

            if (head.left != null) {
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }
        }
        while (!stack2.isEmpty()) {
            var head = stack2.pop();
            System.out.print(head.val + " ");
        }
    }

    public static void widthRecur(TreeNode tree) {
        if (tree == null) {
            return;
        }
        var queue = new LinkedList<TreeNode>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            var head = queue.poll();
            System.out.print(head.val + " ");
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
        }
    }

    public static int maxWidth(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        int max = 1;
        int length = 0;
        var queue = new LinkedList<TreeNode>();
        TreeNode curLayerEnd = tree;
        TreeNode nextLayerEnd = null;
        queue.offer(tree);
        while (!queue.isEmpty()) {
            var head = queue.poll();
            if (head.left != null) {
                queue.offer(head.left);
                nextLayerEnd = head.left;
                length++;
            }
            if (head.right != null) {
                queue.offer(head.right);
                nextLayerEnd = head.right;
                length++;
            }
            if (head == curLayerEnd) {
                if (length > max) {
                    max = length;
                }
                length = 0;
                curLayerEnd = nextLayerEnd;
                nextLayerEnd = null;
            }
        }
        System.out.println(max);
        return max;
    }
}
