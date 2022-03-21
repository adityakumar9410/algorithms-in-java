import java.util.*;

// Find sub-array whose sum equal to given sum
public class AllSubArrayWithSumEqualToGivenNumber {
    /* Method  : using Map
    we store value of (total_sum till current index- given sum ) as key and current index+1 as value
    If(windowSum=total_sum till current index -given sum ) exist in map then we have found the sub-array
    The sub-array with given sum will start at value of key windowSum and end at current index (value of end pointer)
    T.C = O(n),  S.C = O(n)*/
    public static void findSubArraySumWithGivenValue(int[] array, int sum) {
        if (array.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        int prefixSum = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();  //value of this map will be list of starting index for prefix sum as key
        map.put(0, new ArrayList<>());  //if first element in array is equal to given sum
        map.get(0).add(-1);
        for(int index=0;index<array.length;index++){
            prefixSum = prefixSum + array[index];

            //this window sum is stored prefix-sum in map which gives us starting indexes of sub arrays with given sum
            int windowSum = prefixSum - sum;
            if (map.containsKey(windowSum)) {
                List<Integer>indexList=map.get(windowSum);
                for (var startIndex : indexList) {
                    printSubArrays(array, startIndex+1, index);
                }
            }

            if (map.containsKey(prefixSum)) {    //if more than two sub-array with same sum is  possible
                var list = map.get(prefixSum);
                list.add(index);
                map.replace(prefixSum, list);
            } else {
                map.put(prefixSum, new ArrayList<>());
                map.get(prefixSum).add(index);   //Every prefix sum as key will store next index after index till prefix sum calculated
            }

        }
    }
    private static void printSubArrays(int[] array, Integer startValue, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = startValue; i <= end; i++) {
            result.add(array[i]);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 6, 2, -5, 3, 1, 8};
        int[] A = { 3, 4, -7, 1, 3, 3, 1, -4 };
        findSubArraySumWithGivenValue(A, 7);
    }

}
