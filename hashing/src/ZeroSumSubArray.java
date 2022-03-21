import java.util.*;

public class ZeroSumSubArray {
    //Given an array , find sub array with sum of its elements =0
    /* Method-1 :  Brute force
    TC: O(n^2)  || SC : O(1) */
    public static boolean hasZeroSumSubArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int subArraySum = 0;
            for (int j = i; j < array.length; j++) {
                subArraySum += array[j];
                if (subArraySum == 0)
                    return true;
            }
        }
        return false;
    }

    public static List<List<Integer>> findAllZeroSumSubArray(List<Integer> arr) {

        if (arr.size() == 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int subArraySum = 0;
            for (int j = i; j < arr.size(); j++) {
                subArraySum += arr.get(j);
                List<Integer> subArr = new ArrayList<>();
                if (subArraySum == 0) {
                    for (int k = i; k <= j; k++)
                        subArr.add(arr.get(k));

                    result.add(subArr);
                }
            }
        }
        return result;
    }

    /*Method-2 :  Hashing
    TC: O(n) || SC : O(n)*/
    public static boolean hasZeoSumUsingHash(List<Integer> arr) {

        Set<Integer> seen = new HashSet<>();
        seen.add(0);  // To handle array like [5, -5, 10] or [5,-5]

        int prefixSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            prefixSum += arr.get(i);
            if (seen.contains(prefixSum))
                return true;
            else
                seen.add(prefixSum);
        }
        return false;
    }

    //Find whether sub array  with sum=x  exist or not
    public static boolean hasGivenSumUsingHash(List<Integer> arr,  int  sum) {
        Set<Integer> seen = new HashSet<>();
        seen.add(0);  // To handle array like [5, -5, 10] or [5,-5]

        int prefixSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            prefixSum += arr.get(i);
            if (seen.contains(prefixSum-sum))
                return true;
            else
                seen.add(prefixSum);
        }
        return false;
    }
    public static void main(String[] args) {
        //int[]arr={5,-5, 6,-4,-2,8,10};
        //System.out.println(hasZeroSumSubArray(arr));
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5, 3, 8, -2, 8,10));
        // System.out.println(findAllZeroSumSubArray(array));
        //System.out.println(hasZeoSumUsingHash(array));
        System.out.println(hasGivenSumUsingHash(array, 11));
    }
}
