import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class MissingElement {
    /*  Given Two arrays , one element from first array is randomly removed and second array is made from remaining elements
    Find missing element in second array
    By sorting method  TC : O(nlog(n))  || SC : O(1)*/
    public static int findMissingElement1(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int j = 0;
        for (int i = 0; i < arr1.length - 1; i++) {
            if (arr1[i] == arr2[j])
                j++;
            else
                return arr1[i];
        }
        return arr1[arr1.length - 1];
    }

    /*By Hashing
    TC: O(n)  || SC : O(n)
    */
    public static int findMissingElement2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (var  num : arr1) {
            if (hashMap.containsKey(num))
                hashMap.replace(num, hashMap.get(num)+1);
            else
                hashMap.put(num,1);
        }
        for (var  num : arr2) {
            if (hashMap.containsKey(num))
                hashMap.replace(num, hashMap.get(num)-1);
            else
                hashMap.put(num,1);
        }

        for (var key:hashMap.keySet()){
            var value= hashMap.get(key);
            if (value!=0)
                return key;
        }
        return Integer.MAX_VALUE;
    }

    /*   Method 3  :  Bit manipulation
   TC : O(n)   || SC : O(1)*/
    public static int findMissingElement3(int[] arr1, int[] arr2) {
        int result = 0;
        //Performing  XOR with elements in both array and result
        for (int num : arr1)
            result ^= num;

        for (int num : arr2)
            result ^= num;

        return result;
    }


    public static void main(String[] args) {

        int[] ar1 = {5,5,7,7};
        int[] ar2 = {5,5,7};

        System.out.println(findMissingElement1(ar1, ar2));
        System.out.println(findMissingElement2(ar1, ar2));
        System.out.println(findMissingElement3(ar1, ar2));

    }
}
