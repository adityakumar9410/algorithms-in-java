import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class MyQueue {
    //Q[10, 20, 30]  10 is front of queue  . after reversing [30, 20,10]
    public static void reverseQueue(Queue<Integer> queue){
        Stack<Integer>stack=new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());

    }
    public static void main(String[] args) {
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue);
        reverseQueue(queue);
        System.out.println(queue);
    }
}
