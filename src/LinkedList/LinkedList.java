package LinkedList;

public class LinkedList {
    public static void main(String[] args) {
         Node root = null;
         Linked a = new Linked();
         root = a.insert(12,root);
         root = a.insert(99,root);
         root = a.insert(37,root);
         a.printList(root);
         System.out.println("After insertion of node");
         a.insertAtPosition(45,4,root);
         a.printList(root);


    }
}
