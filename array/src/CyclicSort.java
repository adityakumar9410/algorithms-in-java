/*Given an array of number from  1 to n in random order , sort the array*/
public class CyclicSort {
    public static void cyclicSort(int[] array){  // Time : O(n), Space : O(1)
        if(array.length <=1)
            return;
        int i=0;
        while(i<array.length){
            if(array[i] != i+1){
                int destIndex = array[i]-1;
                int temp = array[i];
                array[i] = array[destIndex];
                array[destIndex] = temp;
            }else
                i++;
        }
    }
    // Helper function  to print
    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+"   ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {8,3,4,2,1,7,5,6,};
        printArray(arr);
        cyclicSort(arr);
        printArray(arr);

    }
}
