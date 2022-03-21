import java.util.Arrays;

public class PriorityQueue {
    private int[] items=new int[5];
    private int count;

    public void add(int item){
        if(count==items.length){
            System.out.println("Queue is full ");
            throw new IllegalStateException();
        }
        int i;
        for( i=count-1;i>=0;i--){
            if(items[i]>item)
                items[i+1]=items[i];
            else
                break;
        }
        items[i+1]=item;
        count++;
    }


    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is empty ");
            throw new IllegalStateException();
        }
        return items[--count];
    }
    public boolean isEmpty(){
        return count==0;
    }
    @Override
    public String toString(){
        return Arrays.toString(items);
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.add(5);
        queue.add(1);
        queue.add(87);
        queue.add(56);
        queue.add(30);
        System.out.println(queue);
    }
}
