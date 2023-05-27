package LinkedList;

public class Linked {

    private Node getNewNode(int i) {
        Node a = new Node();
        a.i=i;
        a.next=null;
        return a;
    }

    public Node insert(int i, Node node) {
        if(node == null )
            return getNewNode(i);
        else
            node.next = insert(i,node.next);

        return node;
    }

    public Node insertIterative(int i, Node node){
        if(node == null)
            return getNewNode(i);
        Node firstNode = node;  //keeping in temp variable else head will get lost

        while(node.next!=null)
            node = node.next;  //now  this node is pointing to last element
        node.next = getNewNode(i);
        return firstNode;
    }


    public void printList(Node node) {
        if(node == null)
            return;
        System.out.print(node.i+" ");
        printList(node.next);

        //iterative approach
//        while(node!=null){
//            System.out.println(node.i);
//            node = node.next;
//        }
     }

    public Node insertInFront(int i,Node node){
        Node a = getNewNode(i);
        a.next = node;
        return a;
    }

    public Node insertAtPosition(int i, int position, Node node){
       if(position<1){
           System.out.println("position cannot be less than 1");
           return node;
       }
       if(node==null && position>1){
           System.out.println("Cannot insert as position is greater than element exists");//deals with like entered outlier conditions 1000th position
           return node;
       }
       if(node==null && position==1){
           return getNewNode(i);
       }
       if(position==1){
           Node newNode = getNewNode(i);
           newNode.next=node;
           return newNode;
       }

       node.next = insertAtPosition(i,position-1,node.next);
       return node;
    }
}
