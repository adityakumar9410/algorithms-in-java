//Find the smallest sub-array length such that if we sort it , whole sub-array will be sorted
public class GetMinSubArrayLengthForSorting {
    public static int findMinSubArrayLengthForSorting(int[] array) {
        if (array.length == 0)
            return -1;

        int start = 0;
        while (start < array.length - 1 && array[start] < array[start + 1])// Go on increasing if next element greater than current
            start++;
        if (start == array.length - 1)
            return 0;

        int end = array.length - 1;
        while (end > 0 && array[end - 1] < array[end])
            end--;

        int min = Integer.MAX_VALUE;     // To get min and max between start and end
        int max = Integer.MIN_VALUE;

        for (int i = start + 1; i < end; i++) {
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);
        }
        while (start > 0 && array[start] > min)
            start--;
        while (end < array.length && array[end] < max)
            end++;

        return end - start - 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 0, 22, 13, 8, 15, 18};
        int[] arr1 = {1, 2, 5, 3, 6, 10, 9, 21, 25};
        System.out.println(findMinSubArrayLengthForSorting(arr1));
    }
}
