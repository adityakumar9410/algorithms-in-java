import java.util.HashMap;
import java.util.Map;
//Given an array find smallest sub-array length with given sum i.e 2-3-4 length is 3.
public class SmallestSubArrayLengthWithGivenSum {
    public static int findSmallestSubArrayLengthWithGivenSum(int[] array, int sum) {
        if (array.length == 0) {
            System.out.println("Array is empty");
            return -1;
        }
        int end, totalSumTillNow,smallestLength;
        end = 0;
        totalSumTillNow = 0;
        smallestLength = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        while (end < array.length) {
            totalSumTillNow = totalSumTillNow + array[end];
            //If first element will be equal to given sum , then window sum will be equal to 0 and end & start index will be 0
            map.put(0, 0);
            int windowSum = totalSumTillNow - sum;
            if (map.containsKey(windowSum)) {
                int start = map.get(windowSum);
                smallestLength = Math.min(smallestLength, end - start + 1);
            }
            map.put(totalSumTillNow, ++end);
        }
        return smallestLength != Integer.MAX_VALUE ? smallestLength : -1;

    }

    public static void main(String[] args) {
        int[] arr = { 3,6,2, -5,  3, 1, 8};
        int num= findSmallestSubArrayLengthWithGivenSum(arr,9);
        System.out.println("Smallest subarray length is "+num);
    }

}
