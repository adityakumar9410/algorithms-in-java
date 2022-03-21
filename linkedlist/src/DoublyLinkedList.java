public class DoublyLinkedList {
    private class Node {
        private int data;
        private Node prev;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    public void addAtFirst(int item) {
        var node = new Node(item);
        if (isEmpty())
            head = node;
        else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void forwardPrint() {
        if (isEmpty()) {
            System.out.println("Empty list : ");
            return;
        }

        var curr = head;
        System.out.println("Forward print :  ");
        System.out.print("Head - > ");
        while (curr != null) {
            System.out.print(curr.data + " < -- > ");
            curr = curr.next;
        }
        System.out.print(" null ");
    }

    public void reversePrint() {
        if (isEmpty()) {
            System.out.println("Empty list : ");
            return;
        }
        var curr=head;

        while (curr.next!=null) {   // Going to last node
            curr = curr.next;
        }

        //Printing backward using prev pointer
        System.out.println();
        System.out.println("Reverse print :  ");
        System.out.print("null");
        while (curr!=null){
            System.out.print("  < -- > "+curr.data);
            curr=curr.prev;
        }
        System.out.print(" < -  Head ");
    }


    public static void main(String[] args) {
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.addAtFirst(11);
        dList.addAtFirst(23);
        dList.addAtFirst(77);
        dList.addAtFirst(91);
        dList.addAtFirst(8);

        dList.forwardPrint();
        dList.reversePrint();
    }

}
