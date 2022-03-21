//Get max multiplication two number in an array
public class GetMaxMultiplication {
    public static int getMaxMultiplicationOfTwoNumber(int[] array) {  // Time : O(n), Space : O(1)
        if (array.length < 2)
            return -1;
        if (array.length == 2)
            return array[0] * array[1];

        int smallest = array[0] < array[1] ? array[0] : array[1];
        int secondSmallest = array[0] > array[1] ? array[0] : array[1];
        int greatest = array[0] > array[1] ? array[0] : array[1];
        int secondGreatest = array[0] < array[1] ? array[0] : array[1];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallest) {
                secondSmallest = smallest;
                smallest = array[i];
            } else if (array[i] < secondSmallest)
                secondSmallest = array[i];

            if (array[i] > greatest) {
                secondGreatest = greatest;
                greatest = array[i];
            } else if (array[i] > secondGreatest)
                secondGreatest = array[i];
        }
        int firstTwoMultiplication = smallest * secondSmallest;
        int lastTwoMultiplication = greatest * secondGreatest;

        return firstTwoMultiplication > lastTwoMultiplication ? firstTwoMultiplication : lastTwoMultiplication;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 1, 2, 7, 3};
        int[] arr2 = {3, 5, 7, -12, -9};
        System.out.println(getMaxMultiplicationOfTwoNumber(arr1));
        System.out.println(getMaxMultiplicationOfTwoNumber(arr2));
    }
}
