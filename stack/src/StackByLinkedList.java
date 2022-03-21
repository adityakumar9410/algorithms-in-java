import java.util.NoSuchElementException;
public class StackByLinkedList {
    private class Node {
        private int value;
        private Node next;
        // constructor so we can directly pass value
        public Node(int value) {
            this.value = value;
        }
    }
    private Node top;
    //Push operation
    public void push(int data){
        var node = new Node(data);
        node.next=top;
        top=node;
    }
    //Pop operation
    public int pop(){
        int val;
        if(top==null)
            throw new NoSuchElementException();
        else{
            var second=top.next;
            val=top.value;
            top=second;
            return val;
        }
    }
    //Peek operation
    public int peek() {
        if (!isEmpty())
            return top.value;
        else {
            System.out.println("The stack is empty!!");
            return Integer.MIN_VALUE;
        }
    }
    public boolean isEmpty() {
        return top == null;
    }


    public void deleteStack() {
        top=null;
        System.out.println("Successfully deleted stack ");
    }

    public static void main(String[] args) {
        StackByLinkedList  stack= new StackByLinkedList();
        stack.push(8);
        stack.push(9);
        stack.push(11);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
