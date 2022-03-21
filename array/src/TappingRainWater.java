public class TappingRainWater {
    //Width and length of water column is 1 unit and height is represented by arr value
    //TC: O(n^2) || SC: O(1)
    public static void findTappedRainWater(int[] arr) {
        int result = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int maxLeft = maxOnLHS(arr, i);
            int maxRight = maxOnRHS(arr, i);
            int heightOfTappedWater = Math.min(maxLeft, maxRight) - arr[i];
            result += heightOfTappedWater;
        }
        int vol = result;
        System.out.println("Tapped Water  is " + vol + "  unit^3");
    }

    private static int maxOnRHS(int[] arr, int currIndex) {
        int max = arr[currIndex + 1];
        for (int i = currIndex + 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    private static int maxOnLHS(int[] arr, int currIndex) {
        int max = arr[0];
        for (int i = 0; i < currIndex; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 2, 5};
        findTappedRainWater(arr);
    }
}
