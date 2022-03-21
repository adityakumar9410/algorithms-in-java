//Find missing number from 1 TO N+1 numbers eg. array = {3,2,5,6,1} n = 5, missing number = 4
public class FindMissingNumber {
    public static int findMissingNumber(int[] array){
        if(array.length == 0)
            return -1;
        int i = 0;
        while (i < array.length){
            if(array[i] <= array.length && array[i] != i+1){
                int destIndex = array[i]-1;
                int temp = array[i];
                array[i] = array[destIndex];
                array[destIndex] = temp;
            }else
                i++;
        }
        for( i=0; i<array.length; i++) {
            if (array[i] != i + 1)
                return i + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = {3,2,5,6,1};
        System.out.println(findMissingNumber(arr));
    }
}
