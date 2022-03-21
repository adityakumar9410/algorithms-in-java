public class HeapSort {
    public static void main(String[] args) {
        int[] array = {4, 6, 9, 2, 10, 56, 12, 5, 1, 17, 14};
        printArray(array);
        heapsort(array);
        printArray(array);
    }
    public static void printArray(int []array) {
        for (int n : array) {
            System.out.print(n + ", ");
        }
        System.out.println();
    }
    private static int getParentIndex(int index, int endIndex) {
        if (index < 0 || index > endIndex) {
            return -1;
        }
        return (index - 1) / 2;
    }

    private static int getLeftChildIndex(int index, int endIndex) {
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex > endIndex) {
            return -1;
        }
        return leftChildIndex;
    }

    private static int getRightChildIndex(int index, int endIndex) {
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex > endIndex) {
            return -1;
        }
        return rightChildIndex;
    }

    private static void swap(int[]array,int index1, int index2) {
        int tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
    }

    private static void percolateDown(int[]array,int index, int endIndex) {
        int leftChildIndex = getLeftChildIndex(index, endIndex);
        int rightChildIndex = getRightChildIndex(index, endIndex);

        if (leftChildIndex != -1 && array[leftChildIndex] > array[index]) {
            swap(array,leftChildIndex, index);
            percolateDown(array,leftChildIndex, endIndex);
        }
        if (rightChildIndex != -1 && array[rightChildIndex] > array[index]) {
            swap(array,rightChildIndex, index);
            percolateDown(array,rightChildIndex, endIndex);
        }
    }

    public static void heapify(int[]array,int endIndex) {
        int index = getParentIndex(endIndex, endIndex);
        while (index >= 0) {
            percolateDown(array,index, endIndex);
            index--;
        }
    }

    public static void heapsort(int[]array) {
        heapify(array,array.length - 1);

        int endIndex = array.length - 1;
        while (endIndex > 0) {
            swap(array,0, endIndex);
            endIndex--;
            percolateDown(array,0, endIndex);
        }
    }

}
