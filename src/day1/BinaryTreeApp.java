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
        System.out.println();

        System.out.println("Level Order Traversal using Queue: Space and time complexity O(n): ");
        a.levelOrderTraversalUsingQueue(root);
        System.out.println();

        System.out.println("Level order Traversal in Reverse order using Recursion: ");
        a.levelOrderTraversalInReverseUsingRecursion(root);
        System.out.println();

        System.out.println("Level order traversal in reverse using queue and stack");
        a.levelOrderTraversalWithoutUsingRecursion(root);
        System.out.println();

        System.out.println("Top view of the tree is: ");
        a.printTopView(root);
        System.out.println();

        System.out.println("Bottom view of the tree is: ");
        a.printBottomView(root);
        System.out.println();

        System.out.println("All leaf nodes: ");
        a.printLeafNodes(root);
        System.out.println();

        System.out.println("print left tree: ");
        a.printLeftTree(root);
        System.out.println();

        System.out.println("left view of the tree is: ");
        a.printLeftViewOfTree(root,0);
        System.out.println();

        System.out.println("right view of the tree is: ");
        a.printRightViewOfTree(root,0);
        System.out.println();

        System.out.println("inorder traversal using stack");
        a.inorderTraversalUsingStack(root);
        System.out.println();

        System.out.println("preorder traversal using stack");
        a.preorderTraversalUsingStack(root);
        System.out.println();

        System.out.println("postorder traversal using stack");
        a.postOrderTraversalUsingStack(root);
        System.out.println();

        System.out.println("mirror of a tree");
        //Node res = a.mirrorOfTheTree(root);
        //a.postOrderTraversalUsingStack(res);

        System.out.println("deleting of binary tree");
        Node res1 = a.deleteBinaryTree(root);

        System.out.println("checking if the two trees are identical ");
        boolean b = a.checkIfIdenticalTree(root,root);
        System.out.println(b);


        //We are considering the root node level as 1
        //if we are getting op level as 0 this means that the node is not present.
        System.out.println("Get level of the node");
        int levelStart = 1; //start of the level
        int val = 5; //value to be searched
        int l= a.getLevelOfTheNode(root,val,levelStart);
        System.out.println("level of "+val+ " is "+l);

    }

}
