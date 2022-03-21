public class Heapify {
    //Convert an array to max heap
    public  void heapify(int[] array) {
        var lastParentIndex = array.length / 2 - 1;  //We only need to adjust non leaf nodes
        for (var i = lastParentIndex; i >= 0; i--)
            heapify(array, i);
    }
    private  void heapify(int[] array, int index) {
        var largerIndex = index;
        var leftIndex = index * 2 + 1;
        if (leftIndex < array.length &&
                array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;
        var rightIndex = index * 2 + 2;
        if (rightIndex < array.length &&
                array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        if (index == largerIndex)   //if parent is largest
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex);   //if after swapping  heap gets unbalanced
    }

    private  void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void main(String[] args) {
        int[]arr={4,6,3,8,9,12,34,25,30};
        Heapify  heap=new Heapify();
        heap.heapify(arr);
        System.out.println(arr[0]);

    }

}
