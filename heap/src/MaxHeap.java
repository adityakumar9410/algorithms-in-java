public class MaxHeap {
    private int[] items;
    private int size;
    int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
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
        while (index > 0 && items[index] > items[parentIndex(index)]) {
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
        while (index <=size && !isValidParent(index)) {
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index) > rightChild(index)) ?
                leftChildIndex(index) :
                rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <=size;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))  //if parent is leaf node
            return true;

        var isValid = items[index] >= leftChild(index);

        if (hasRightChild(index))
            isValid &= items[index] >= rightChild(index);

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


    public int max() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[0];
    }
    public  boolean isMaxHeap(int[] array) {
        return isMaxHeap(array, 0);
    }
    private  boolean isMaxHeap(int[] array, int index) {
        // All leaf nodes are valid
        var lastParentIndex = (array.length - 2) / 2;
        if (index > lastParentIndex)  //If nodes are leaf node
            return true;

        var leftChildIndex = index * 2 + 1;
        var rightChildIndex = index * 2 + 2;

        var isValidParent =
                array[index] >= array[leftChildIndex] &&
                        array[index] >= array[rightChildIndex];

        return isValidParent &&
                isMaxHeap(array, leftChildIndex) &&
                isMaxHeap(array, rightChildIndex);
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(8);
        heap.insert(5);
        heap.insert(25);
        heap.insert(15);
        heap.insert(40);
        heap.insert(35);
        heap.insert(30);
        heap.insert(10);

        System.out.println("Max value in heap :  " + heap.max());
    }
}
