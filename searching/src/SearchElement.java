/*Given an circularly sorted array which is rotated find a given element x in array*/
public class SearchElement {
    public static int searchElement(int[] array , int n, int target){
        int low = 0;
        int high = array.length-1;
        while (low <= high){
            int mid = (low+high)/2;

            if(array[mid] == target)
                return mid;
            if(array[mid] <= array[high]){
                if(target > array[mid] && target <= array[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
            if(array[low] <= array[mid]){
                if(target >= array[low] && target < array[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {12,13,14,15,16,2,4,5,6,7,8,9,10};
        int index = searchElement(arr, arr.length, 15);
        if(index == -1)
            System.out.println("Given number is not found");
        else
            System.out.println("Index of given number is :  " +index);
    }

}
