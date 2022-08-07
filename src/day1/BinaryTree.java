package day1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;
}

public class BinaryTree {
    static int sum;
    public Node createNewNode(int k){
        Node a = new Node();
        a.data = k;
        a.left = null;
        a.right = null;
        return a;
    }

    public void preorder(Node root) {
        if(root==null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(Node root) {
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void postorder(Node root) {
        if(root==null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
 //this logic implemented using preorder traversal logic
    public int sumOfTree(Node root) {
        if(root==null)
            return 0;
        sum = sum + root.data;
        sumOfTree(root.left);
        sumOfTree(root.right);
        return sum;
    }

    public int sumOfTreeSimplified(Node root) {
        if(root==null)
            return 0;
        return root.data + sumOfTreeSimplified(root.left) + sumOfTreeSimplified(root.right);
    }

    public int differenceOfOddEvenLevels(Node root) {
        if(root==null)
            return 0;
        return root.data - differenceOfOddEvenLevels(root.left) - differenceOfOddEvenLevels(root.right);
    }

    public int totalNumberOfNodes(Node root) {
        if(root==null)
            return 0;
        return 1+totalNumberOfNodes(root.left)+totalNumberOfNodes(root.right);
    }

    public int  totalLeafNodes(Node root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        return totalLeafNodes(root.left) + totalLeafNodes(root.right);
    }

    public int heightOfTree(Node root) {
        if(root == null)
            return -1;
        return Math.max(heightOfTree(root.left),heightOfTree(root.right))+1;
    }

    public void printNodesAtLevel(Node root, int level) {
        if(root==null)
            return;
        if(level==1)
        {
            System.out.print(root.data+" ");
            return;
        }
        printNodesAtLevel(root.left,level-1);
        printNodesAtLevel(root.right,level-1);
    }

    /**
     * This has O(n2) complexity as heightfunction has complexity O(n)
     * printNodesAtLevel also O(n)
     */
    public void levelOrderTraversalRecursive(Node root) {
        for(int i=1;i<heightOfTree(root)+2;i++) {
            printNodesAtLevel(root, i);
            System.out.println();
        }
    }

    public void levelOrderTraversalUsingQueue(Node root) {
        if(root==null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            Node nd = queue.remove();
            System.out.print(nd.data+" ");
            if(nd.left!=null)
                queue.add(nd.left);
            if(nd.right!=null)
                queue.add(nd.right);
        }
    }

    public void levelOrderTraversalInReverseUsingRecursion(Node root) {
        for(int i=heightOfTree(root)+1;i>=1;i--) {
            printNodesAtLevel(root, i);
            System.out.println();
        }
    }

    public void levelOrderTraversalInReverseUsingQueue(Node root) {
        if(root==null)
            return;
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            if(stack.peek().left!=null)
                stack.push(stack.peek().left);
            if(stack.peek().right!=null)
                stack.push(stack.peek().right);
            System.out.print(stack.pop().data+" ");
        }
    }
}
