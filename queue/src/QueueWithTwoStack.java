import java.util.Stack;
public class QueueWithTwoStack {
    private  Stack<Integer>stack1=new Stack<>();
    private Stack<Integer>stack2=new Stack<>();
    //O(1)
    public void enqueue(int item){
        //Always add item to first stack
        stack1.push(item);
    }
    //O(n)
    public int dequeue(){
        if(stack1.isEmpty() && stack2.isEmpty())
            throw new IllegalStateException();
        if(stack2.isEmpty())
            while (!stack1.isEmpty())
                moveStack1ToStack2();

       return stack2.pop();
    }
    private void moveStack1ToStack2() {
        stack2.push(stack1.pop());
    }
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    public int peek(){
        if(stack1.isEmpty() && stack2.isEmpty())
            throw new IllegalStateException();

        if(stack2.isEmpty())
            while (!stack1.isEmpty())
                moveStack1ToStack2();

        return stack2.peek();

    }

    public static void main(String[] args) {
        QueueWithTwoStack queue=new QueueWithTwoStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        var first=queue.dequeue();
        System.out.println(first);
    }

}
