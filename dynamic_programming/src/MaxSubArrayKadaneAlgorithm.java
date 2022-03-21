public class MaxSubArrayKadaneAlgorithm {
    //Given an array , find max sum sub array
    //TC:O(N) || SC:O(1)
    public static int findMaxSumSubArray(int[] array){
        if (array.length==0){
            System.out.println("Array is empty");
            return Integer.MIN_VALUE;
        }
        int maxCurrent=array[0];
        int maxGlobal=array[0];
        for (int i=1;i<array.length;i++){
            int num=array[i];
            maxCurrent=Math.max(num, maxCurrent+num);   // this gives max of ith num or sum up to last plus ith number
            maxGlobal=Math.max(maxGlobal, maxCurrent);
        }
        return maxGlobal;
    }
    public static void main(String[] args) {
        int[]arr={3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4};
        System.out.println(findMaxSumSubArray(arr));
    }
}
