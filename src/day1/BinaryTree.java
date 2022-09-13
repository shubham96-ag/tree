package day1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

class Node{
    int data;
    Node left;
    Node right;
    int height;
}

public class BinaryTree {
    static int sum;

    public Node createNewNode(int k) {
        Node a = new Node();
        a.data = k;
        a.left = null;
        a.right = null;
        return a;
    }

    public void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    //this logic implemented using preorder traversal logic
    public int sumOfTree(Node root) {
        if (root == null)
            return 0;
        sum = sum + root.data;
        sumOfTree(root.left);
        sumOfTree(root.right);
        return sum;
    }

    public int sumOfTreeSimplified(Node root) {
        if (root == null)
            return 0;
        return root.data + sumOfTreeSimplified(root.left) + sumOfTreeSimplified(root.right);
    }

    public int differenceOfOddEvenLevels(Node root) {
        if (root == null)
            return 0;
        return root.data - differenceOfOddEvenLevels(root.left) - differenceOfOddEvenLevels(root.right);
    }

    public int totalNumberOfNodes(Node root) {
        if (root == null)
            return 0;
        return 1 + totalNumberOfNodes(root.left) + totalNumberOfNodes(root.right);
    }

    public int totalLeafNodes(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return totalLeafNodes(root.left) + totalLeafNodes(root.right);
    }

    public int heightOfTree(Node root) {
        if (root == null)
            return -1;
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    public void printNodesAtLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.data + " ");
            return;
        }
        printNodesAtLevel(root.left, level - 1);
        printNodesAtLevel(root.right, level - 1);
    }

    /**
     * This has O(n2) complexity as heightfunction has complexity O(n)
     * printNodesAtLevel also O(n)
     */
    public void levelOrderTraversalRecursive(Node root) {
        for (int i = 1; i < heightOfTree(root) + 2; i++) {
            printNodesAtLevel(root, i);
            System.out.println();
        }
    }

    public void levelOrderTraversalUsingQueue(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            Node nd = queue.remove();
            System.out.print(nd.data + " ");
            if (nd.left != null)
                queue.add(nd.left);
            if (nd.right != null)
                queue.add(nd.right);
        }
    }

    public void levelOrderTraversalInReverseUsingRecursion(Node root) {
        for (int i = heightOfTree(root) + 1; i >= 1; i--) {
            printNodesAtLevel(root, i);
            System.out.println();
        }
    }

    public void levelOrderTraversalWithoutUsingRecursion(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()!=0){
            Node rm = queue.remove();
            stack.push(rm);
            if(rm.right!=null)
                queue.add(rm.right);
            if(rm.left!=null)
                queue.add(rm.left);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop().data+" ");
        }
    }

    public void printTopView(Node root) {
        if(root==null)
            return;
        Queue<Node> queue = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        queue.add(root);
        while(queue.size()!=0){
            Node temp = queue.remove();
            int ht  = temp.height;

            if(map.get(ht)==null) //whatever node is coming first time we are only placing that. This if condition will refrain any new addition
                map.put(temp.height,temp.data);  //vertical height is key  : value is the node data

            if(temp.left!=null){
                temp.left.height=ht-1;
                queue.add(temp.left);
            }

            if(temp.right!=null)
            {
                temp.right.height=ht+1;
                queue.add(temp.right);
            }
        }
        System.out.println("Top view of tree is : "+map.values());
    }

    public void printBottomView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        queue.add(root);

        while(queue.size()!=0){
            Node temp = queue.remove();
            int ht = temp.height;

            map.put(ht,temp.data);
            if(temp.left!=null){
                temp.left.height=ht-1;
                queue.add(temp.left);
            }
            if(temp.right!=null){
                temp.right.height=ht+1;
                queue.add(temp.right);
            }
        }
        System.out.println("Bottom view of tree is: "+map.values());
    }

    public void printLeafNodes(Node root) {
        if(root==null)
            return;
        if(root.left==null && root.right==null) {
            System.out.print(root.data + " ");
            return;
        }
        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }


    public void printLeftTree(Node root) {
        if(root==null)
            return;
        System.out.print(root.data+" ");
        if(root.left!=null)
        printLeftTree(root.left);
    }

    public int maxLevel = 0;
    //In this we just have to print the first element at each level
    //Complexity is O(n) as we traverse each element once
    public void printLeftViewOfTree(Node root,int level) {
        if(root==null)
            return;
        if(level>=maxLevel){
            System.out.print(root.data+" ");
            maxLevel++;
        }
        printLeftViewOfTree(root.left,level+1);
        printLeftViewOfTree(root.right,level+1);
    }

    int maxLevel2=0;
    public void printRightViewOfTree(Node root, int level) {
        if(root==null)
            return;
        if(level>=maxLevel2){
            System.out.print(root.data+" ");
            maxLevel2++;
        }
        printRightViewOfTree(root.right,level+1);
        printRightViewOfTree(root.left,level+1);
    }

    public void inorderTraversalUsingStack(Node root) {
        if(root==null)
            return;
        Stack<Node> st= new Stack<>();
        while(root!=null){
            st.push(root);
            root=root.left;
        }

        while(!st.isEmpty()){
            Node t = st.pop();
            System.out.print(t.data+" ");
            if(t.right!=null){
                Node tmp = t.right;
                while(tmp!=null){
                    st.push(tmp);
                    tmp = tmp.left;
                }
            }
        }
    }
//we are just adding root node as seeding and then adding right node first then left
//doing so will make sure left gets removed first
    public void preorderTraversalUsingStack(Node root) {
        if(root==null)
            return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node temp = st.pop();
            System.out.print(temp.data+" ");
            if(temp.right!=null){
                st.push(temp.right);
            }
            if(temp.left!=null){
                st.push(temp.left);
            }
        }
    }

    //We are just adding seeding in st1 and adding left node first then the right after popping element to st2
    //popping from st2 and printing result.
    public void postOrderTraversalUsingStack(Node root) {
        if(root==null)
            return;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            Node temp = st1.pop();
            st2.push(temp);
            if(temp.left!=null)
                st1.push(temp.left);
            if(temp.right!=null)
                st1.push(temp.right);
        }
        while(!st2.isEmpty()){
            System.out.print(st2.pop().data+" ");
        }
    }

    //complexity O(n)
    public Node mirrorOfTheTree(Node root) {
        if(root==null)
            return null;
        //swapping left and right node
        Node temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorOfTheTree(root.left);
        mirrorOfTheTree(root.right);
        return root;
    }

//just similar to postorder traversal Left right node
    public Node deleteBinaryTree(Node root) {
        if(root==null)
            return null;
        Node left = deleteBinaryTree(root.left);
        Node right = deleteBinaryTree(root.right);
        System.out.println("Deleting node "+root.data);
        //cleaning memory for the node
        root = null;
        return root;
    }

    //also can check if preorder and postorder traversals are identical
    public boolean checkIfIdenticalTree(Node t1, Node t2) {
        if(t1==null && t2==null)
            return true;
        if(t1==null || t2==null)
            return false;
        return t1.data==t2.data
                && checkIfIdenticalTree(t1.left,t2.left)
                && checkIfIdenticalTree(t1.right,t2.right);
    }

    //We are considering the root node level as 1
    public int getLevelOfTheNode(Node root, int val, int level) {
        if(root==null)
            return 0;
        int l;
        if(root.data==val)
            return level;
        l=getLevelOfTheNode(root.left,val,level+1);

        //this means that you have got the value in the left subtree. Hence, just return level. No need to call function on right subtree.
        if(l!=0)
            return l;

        l=getLevelOfTheNode(root.right,val,level+1);
        return l;
    }
}

