package day1;

public class BinaryTreeApp {
    public static void main(String[] args) {
        BinaryTree a = new BinaryTree();
        Node root = a.createNewNode(2);
        root.left = a.createNewNode(7);
        root.right = a.createNewNode(5);
        root.left.left = a.createNewNode(2);
        root.left.right = a.createNewNode(6);
        root.left.right.left = a.createNewNode(5);
        root.left.right.right = a.createNewNode(11);
        root.right.right = a.createNewNode(9);
        root.right.right.left = a.createNewNode(4);

        System.out.println("Preorder: ");
        a.preorder(root);
        System.out.println();

        System.out.println("Inorder: ");
        a.inorder(root);
        System.out.println();

        System.out.println("Postorder: ");
        a.postorder(root);
        System.out.println();

        System.out.println("Sum of binary tree: "+a.sumOfTree(root));
        System.out.println();

        System.out.println("Sum of binary tree Simplified: "+ a.sumOfTreeSimplified(root));
        System.out.println();

        System.out.println("difference of odd even levels of tree: "+ a.differenceOfOddEvenLevels(root));
        System.out.println();

        System.out.println("Total number of nodes in a binary tree: "+ a.totalNumberOfNodes(root));
        System.out.println();

        System.out.println("Total number of leaf nodes in binary tree: "+ a.totalLeafNodes(root));
        System.out.println();

        System.out.println("Height of the tree: "+a.heightOfTree(root));
        System.out.println();

        System.out.println("nodes at level: ");
        a.printNodesAtLevel(root,2);
        System.out.println();

        System.out.println("LevelOrder Traversal Recursive: ");
        a.levelOrderTraversalRecursive(root);

        System.out.println("Level Order Traversal using Queue: Space and time complexity O(n): ");
        a.levelOrderTraversalUsingQueue(root);
        System.out.println();

        System.out.println("Level order Traversal in Reverse order using Recursion: ");
        a.levelOrderTraversalInReverseUsingRecursion(root);

        System.out.println("reverse Level order traversal using queue");
        //a.levelOrderTraversalInReverseUsingQueue(root);

        System.out.println("Top view of the tree is: ");
        a.printTopView(root);

        System.out.println("Bottom view of the tree is: ");
        a.printBottomView(root);
    }

}
