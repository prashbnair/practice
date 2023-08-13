package practice.ds;

import java.util.*;

public class BinaryTree {
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);

        root.left = two;
        root.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        seven.right = eight;

        System.out.println(depth(root));
    }

    private static void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.println(node.value);
        inorder(node.right);
    }

    private static void inorderLoop(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);

        while(!stack.empty()) {
            node = node.left;
            if(node != null) {
                stack.add(node);
            }
            else {
                node = stack.pop();
                System.out.println(node.value);
                if(node.right != null) {
                    node = node.right;
                    stack.push(node);
                }
            }
        }
    }

    private static void preorder(Node node) {
        if(node == null) return;

        System.out.println(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    private static void preorderLoop(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        System.out.println(node.value);
        while(!stack.empty()) {
            node = node.left;
            if(node != null) {
                System.out.println(node.value);
                stack.add(node);
            }
            else {
                node = stack.pop();
                if (node.right != null) {
                    node = node.right;
                    System.out.println(node.value);
                    stack.add(node);
                }
            }
        }
    }

    private static void postorder(Node node) {
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value);
    }

    private static void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            Node parent = queue.remove();
            System.out.print(parent.value);
            if(parent.left != null) queue.add(parent.left);
            if(parent.right != null) queue.add(parent.right);

        }
    }

    private static void levelOrderRecursion(Node node) {

    }

    private static void view(Node root) {
        List<Node> leftView = new ArrayList<>();
        List<Node> rightView = new ArrayList<>();
        leftView(root, 0, leftView);
        leftView.forEach(x -> System.out.println(x.value));
        System.out.println();
        rightView(root, 0, rightView);
        rightView.forEach(x -> System.out.println(x.value));
    }

    private static void leftView(Node node, int depth, List<Node> leftView) {
        if (node == null) return;
        if (leftView.size() == depth) {
            leftView.add(node);
        }
        leftView(node.left, depth + 1, leftView);
        leftView(node.right, depth + 1, leftView);
    }

    private static void rightView(Node node, int depth, List<Node> rightView) {
        if (node == null) return;
        if (rightView.size() == depth && node != null) {
            rightView.add(node);
        }
        rightView(node.right, depth + 1, rightView);
        rightView(node.left, depth + 1, rightView);
    }

    private static int depth(Node root) {
        if (root == null) return 0;

        int left = depth(root.left) + 1;
        int right = depth(root.right) + 1;

        return Math.max(left, right);

    }
}
