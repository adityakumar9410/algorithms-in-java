import java.util.NoSuchElementException;
public class SinglyLinkedList {

    private class Node {
        private int value;
        private Node next;
        // constructor so we can directly pass value
        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    public void addAtLast(int item) {
        var node = new Node(item);   // we use var to let java compiler decide type of variable

        if (head == null)
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
    }

    public void addAtFirst(int item) {
        var node = new Node(item);
        if (isEmpty())
            head = tail = node;
        else {
            node.next = head;
            head = node;
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void insertAtNthPosition(int item, int position) {
        var node = new Node(item);
        if (position == 1) {
            node.next = head;
            head = node;
            return;
        }
        try {
            var temp = head;
            for (int i = 0; i < position - 2; i++)
                temp = temp.next;      // temp  will point to position-1 node

            node.next = temp.next;   // In link of node we are setting address of old Nth node
            temp.next = node;           //Link of n-1th node now contains address of new Nth node
        } catch (NullPointerException e) {
            System.out.println();
            System.out.println("Exception :  " + e.getMessage());
            System.out.println("Tried to insert at index more than number of elements");
        }
    }

    public int indexOf(int item) {
        int index = 0;
        var current = head;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeAtFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (head == tail) {
            head = tail = null;
            return;
        }
        var second = head.next;
        head.next = null;
        head = second;
    }

    public void removeAtLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (head == tail) {
            head = tail = null;
            return;
        }
        var previous = getPrevious(tail);
        tail = previous;
        tail.next = null;

    }

    private Node getPrevious(Node node) {
        var current = head;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public void removeAtKthPosition(int k) {
        if (isEmpty())
            System.out.println("Linked list is empty");

        if (k > getSizeOfLinkedList()) {
            System.out.println("Entered position is greater than nodes in linked list ");
            return;
        }

        var temp1 = head;
        for (int i = 0; i < k - 2; i++)
            temp1 = temp1.next;        // temp1 points to N-1th position

        var temp2 = temp1.next;    // temp2 points to Nth position
        temp1.next = temp2.next;    //temp1 now points N+1th position
        temp2 = null;
    }

    public int getSizeOfLinkedList() {
        if (isEmpty())
            return 0;
        int size = 0;
        var current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
    public boolean ifValueExist(int value) {
        if (isEmpty())
            return false;

        var current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /*Insert the data into the correct position in a sorted list.Assume that the list is sorted in
    ascending order.
*/
    public void insertSorted(int data) {
        if (head == null || head.value > data) {
            var next = head;
            head = new Node(data);
            head.next = next;
        } else {
            var curr = head;
            while (curr.next != null && curr.next.value < data) {
                curr = curr.next;
            }
            var next = curr.next;  //this will point to first greater  value than data
            curr.next = new Node(data);  //current is pointing to last less value
            curr.next.next = next;
        }

    }

    public void reverseList() {
        if (head == null || head.next == null)
            return;

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            var next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void removeDuplicates() {
        int count = getSizeOfLinkedList();
        if (count == 0 || count == 1)
            return;
        else {
            var curr = head;
            while (curr.next != null) {
                if (curr.next.value - curr.value == 0)
                    curr.next = curr.next.next;
                else
                    curr = curr.next;
            }
        }
    }



    public void printList() {
        Node current = head;

        System.out.print("Head->");
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("null");
    }

    public void deleteLinkedList() {
        head = null;
    }


    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        /* list2.insertSorted(8);
        list2.insertSorted(1);
        list2.insertSorted(9);
        list2.insertSorted(3);
        list2.printList();*/
        list.addAtLast(10);
        list.addAtLast(20);
        list.addAtLast(30);
        list.addAtFirst(5);
        list.addAtLast(38);
        list.addAtLast(33);
        list.addAtLast(67);
        list.addAtLast(78);

        list.printList();
        //list.removeDuplicates();
        list.removeAtKthPosition(3);
        System.out.println();
        list.printList();
        /*System.out.println();
        list.reverseList();
        list.printList();*/
        /*System.out.println("If given value exist : " + list.ifValueExist(30));
        System.out.println("Size of linkedList is  :  " + list.getSizeOfLinkedList());*/
        /*list.removeAtKthPosition(1);
        list.printList();

        list.removeAtLast();
        System.out.println();
        list.removeAtFirst();
        list.printList();
        System.out.println();
        System.out.println(list.contains(70));*/
    }


}
