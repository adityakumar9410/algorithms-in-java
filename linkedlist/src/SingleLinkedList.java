public class SingleLinkedList<T extends Comparable<T>> implements Cloneable {
    private class SingleNode<T extends Comparable<T>> {
        private T data;
        private SingleNode<T> next;

        public SingleNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private SingleNode<T> head = null;

    public SingleLinkedList() {
    }

    public void addNodeAtLast(T data) {
        if (head == null)
            head = new SingleNode<T>(data);
        else {
            SingleNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new SingleNode<T>(data);
        }
    }

    public void printLinkedList() {
        if (head == null)
            System.out.println("There is no node in the linked list ");
        else {
            SingleNode<T> current = head;
            int i = 1;
            while (current != null) {
                System.out.println("In the node " + i + " value stored is " + current.data);
                current = current.next;
                i++;
            }
        }
    }

    public int countNodes() {
        if (head == null) {
            return 0;
        } else {
            SingleNode<T> curr = head;
            int count = 0;
            while (curr != null) {
                curr = curr.next;
                count++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addNodeAtLast(23);
        list.addNodeAtLast(98);
        list.addNodeAtLast(14);
        list.addNodeAtLast(68);
        System.out.println("Printing linked list :  ");
        list.printLinkedList();
        System.out.println("Total node in list :  " + list.countNodes());

    }
}
