public class EquilibPoint {
    //A number is equilibrium  point in array if  sum of number towards its left == sum of num towards its right
    public static boolean equilibriumPoint(int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++)
            totalSum += arr[i];

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int rightSum=totalSum-arr[i];
            if (leftSum == rightSum)
                return true;

            leftSum += arr[i];
            totalSum -= arr[i];
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 8, -9, 20, 6};   //  20 is equilibrium point
        System.out.println(equilibriumPoint(arr));
    }

}
