 public class JumpSearch {
    //TC :  O(sqrt(n))
     public static int jumpSearch(int[] array, int target) {
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;
        while (array[next - 1] < target) {
            start = next;
            if (start >= array.length)
                break;
            next += blockSize;
            if (next > array.length)
                next = array.length;
        }
        for (var i = start; i < next; i++) {
            if (array[i] == target)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 9, 13, 15, 23, 45, 56, 98};
        int target = 23;
        int index = jumpSearch(arr, target);
        System.out.println("Number " + target + "  is present at index  " + index);
    }
}
