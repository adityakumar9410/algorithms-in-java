import java.util.Arrays;

/**
 * Find tripletSum which is closest to given sum. e.g In the array [2,-3,4,-2]
 * find triplet whose sum is near to 1.
 */
public class TripletSum {

  public static int findTripletSumWhichIsCloseToGivenSum(int[] arr, int sum) {
    Arrays.sort(arr);

    int minDiff = Integer.MAX_VALUE;
    int closestSum = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length - 2; i++) {
      int start = i + 1;
      int end = arr.length - 1;

      while (start < end) {
        int tripletSum = arr[i] + arr[start] + arr[end];

        if (Math.abs(sum - tripletSum) <= minDiff && tripletSum <closestSum) {
          minDiff = Math.abs(sum - tripletSum);
          closestSum = tripletSum;
        }

        if (tripletSum == sum) {
          return tripletSum;
        } else if (tripletSum < sum) {
          start++;
        } else {
          end--;
        }
      }
    }
    return closestSum;
  }

  public static void main(String[] args) {
    int[] array = { 2, -2, 4, -2 };
    System.out.println(findTripletSumWhichIsCloseToGivenSum(array, 1));
  }
}