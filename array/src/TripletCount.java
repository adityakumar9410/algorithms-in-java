import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Find number of  triplet in array whose sum is less than given sum.
 */
public class TripletCount {
  public static int findNumberOfTripletWhoseSumLessThanGivenSum(int[] arr, int sum) {
    Arrays.sort(arr);
    int tripletCount = 0;
    for (int i = 0; i < arr.length - 2; i++) {
      int start = i + 1;
      int end = arr.length - 1;

      while (start < end) {
        int tempSum = arr[i] + arr[start] + arr[end];
        if (tempSum < sum) {
          tripletCount = tripletCount + end - start;
          start++;
        } else
          end--;
      }
    }
    return tripletCount;
  }

  public static List<List<Integer>> findTripletsWhoseSumIsLessThanGivenSum(int[] arr, int sum) {
    Arrays.sort(arr);

    List<List<Integer>> allTriplets = new ArrayList<>();

    for (int i = 0; i < arr.length - 2; i++) {
      int start = i + 1;
      int end = arr.length - 1;

      while (start < end) {
        int tempSum = arr[i] + arr[start] + arr[end];

        if (tempSum < sum) {
          int k = start;
          while (k < end) {
            allTriplets.add(Arrays.asList(arr[i], arr[k], arr[end]));
            k++;
          }
          start++;
        } else
          end--;
      }
    }
    return allTriplets;
  }
  public static void main(String[] args) {
    int[] array = { 1, 2, -3 };
    System.out.println(findNumberOfTripletWhoseSumLessThanGivenSum(array, 1));
    System.out.println(findTripletsWhoseSumIsLessThanGivenSum(array, 1));
  }
}