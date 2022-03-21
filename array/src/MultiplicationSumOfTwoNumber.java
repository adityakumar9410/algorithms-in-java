/*Given an array find the whether multiplication of any two number in array is
* sum of a given value*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class MultiplicationSumOfTwoNumber {
    //Check whether multiplication of two number is equal to given target value
    //Method 1 : brute force
    //Start with first element in array and multiply with rest of element in array
    //Time : O(n^2)   || Space : O(1)
    public static boolean bruteForceMethod(int[] array, int value ){
        int n = array.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(array[i]*array[j] == value)
                    return true;
            }
        }
        return false;
    }

    // Method 2 : Two pointer method   (all number in array must be positive
    //Sort the array
    // Initialize start and end pointer with index of first and last element of array
    //multiply first and last element , If multiplication < value , then increase start.
    //If multiplication is greater than value then decrease end
    // Time : O(nlogn) + O(n)=>O(nlogn)
    //Space : O(1)
    public static boolean twoPointerMethod(int[] array, int value){
        int start = 0;
        int end = array.length-1;
        Arrays.sort(array);
        while (start <= end){
            if(array[start]*array[end] == value)
                return true;
            else if  (array[start]*array[end] < value)
                start++;
            else
                end--;
        }
        return false;
    }
    //Method 3: Using hashing
    //Iterate through the array , If value%arr[i]==0 && value/arr[i] exist in hashSet then return true otherwise add to hashSet
    // Time: O(n)
    //Space : O(n)
    public static boolean checkMultiplicationEqualToValue(int[] array, int value){
        Set<Integer> set = new HashSet<>();
        for(int i=0; i < array.length; i++){
            if(value%array[i] == 0 && set.contains(value/array[i]))
                return true;
            else
                set.add(array[i]);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {4,1,3,10,7,5,8};
        System.out.println(bruteForceMethod(arr, 15));
        System.out.println(twoPointerMethod(arr, 15));
        System.out.println(checkMultiplicationEqualToValue(arr, 15));
    }
}
