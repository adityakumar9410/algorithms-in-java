public class MaxSumOfIndexAndArrayElement {
    /*Given an array, only rotation operation is allowed on array. We can rotate the array as many times as we want.
    Return the maximum possible of summation of i*arr[i].
    Examples :
    Input: arr[] = {1, 20, 2, 10}
   Output: 72
   We can 72 by rotating array twice.
   {2, 10, 1, 20}
   20*3 + 1*2 + 10*1 + 2*0 = 72*/

    // Returns max possible value of i*arr[i]
    //TC:O(N)||SC:O(1)
    public static int maxSum(int[] arr) {
        // Find array sum and i*arr[i] with no rotation
        int arrSum = 0;  // Stores sum of arr[i]
        int currVal = 0;  // Stores sum of i*arr[i]
        for (int i = 0; i < arr.length; i++) {
            arrSum = arrSum + arr[i];
            currVal = currVal + (i * arr[i]);
        }

        // Initialize result as 0 rotation sum
        int maxVal = currVal;

        // Try all rotations one by one and find  the maximum rotation sum.
        for (int j = 1; j < arr.length; j++) {
            currVal = currVal + arrSum - arr.length * arr[arr.length - j];    //Rj - Rj-1 = arrSum - n * arr[n-j] where Rj is jTh rotation
            if (currVal > maxVal)
                maxVal = currVal;
        }

        // Return result
        return maxVal;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(maxSum(arr));
    }
}
