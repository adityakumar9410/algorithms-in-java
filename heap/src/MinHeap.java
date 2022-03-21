public class MinHeap {

    private int[] items;
    private int size;
    int maxSize;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size=0;
        this.items = new int[maxSize];
    }

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException();

        items[size++] = value;

        bubbleUp();
    }
    private void bubbleUp() {
        var index = size - 1;
        while (index > 0 && items[index] < items[parentIndex(index)]) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }
    private int parentIndex(int index) {
        return (index - 1) / 2;
    }
    private void swap(int first, int second) {
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();
        var root = items[0];
        items[0] = items[--size];
        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        var index = 0;
        while (index <= size && !isValidParent(index)) {
            var smallerChildIndex = smallerChildIndex(index);
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    private int smallerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index) <  rightChild(index)) ?
                leftChildIndex(index) :
                rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        var isValid = items[index] <= leftChild(index);

        if (hasRightChild(index))
            isValid &= items[index] <= rightChild(index);

        return isValid;
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    public boolean isFull() {
        return size == items.length;
    }



    public int min() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[0];
    }

    public static void main(String[] args) {
        MinHeap heap=new MinHeap(8);
        heap.insert(56);
        heap.insert(5);
        heap.insert(45);
        heap.insert(34);
        heap.insert(23);
        heap.insert(35);
        //heap.remove();
        System.out.println(heap.min());

    }
}
