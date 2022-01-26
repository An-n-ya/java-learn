package java_vscode.HelloWorld.src.BinaryTree;

import java.util.LinkedList;

public class TreeNodeUtil {
    /**
     * 一维数组转换二叉树结构
     * 
     * @param array
     * @return
     */
    public static TreeNode arrayToTreeNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

    public static Integer[] treeNodeToArray(TreeNode tree) {
        if (tree == null) {
            return new Integer[] {};
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<Integer> stack = new LinkedList<Integer>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            var head = queue.poll();

            if (head == null) {
                stack.offer(null);
                continue;
            } else {
                stack.offer(head.val);
            }
            // stack.push(head.val);
            if (head.left != null) {
                queue.offer(head.left);
            } else if (head.right != null) {
                queue.offer(null);
            }
            if (head.right != null) {
                queue.offer(head.right);
            } else if (head.left != null) {
                queue.offer(null);
            }
        }
        return stack.toArray(new Integer[0]);
    }

}