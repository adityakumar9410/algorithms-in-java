import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Find triplet with given target sum in an array. Time : O(n^2) | Space : O(1)
public class FindTriplet {
    public static List<List<Integer>> findTriplet(int[] array, int targetSum) {
        Arrays.sort(array);
        List<List<Integer>> allTriplets = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            int tempSum = targetSum - array[i];
            int start = i + 1;
            int end = array.length - 1;
            while (start < end) {
                int t = array[start] + array[end];
                if (t == tempSum) {
                    allTriplets.add(Arrays.asList(array[start], array[end], array[i]));
                    start++;
                    end--;
                } else if (t < tempSum) {
                    start++;
                } else
                    end--;
            }
        }
        return allTriplets;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 4, -2, -1};
        System.out.println(findTriplet(arr, 1));
    }
}
