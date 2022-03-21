public class NumberOfOccurrences {
    public static int firstOccurrence(int [] array ,  int target){
        int low = 0;
        int high = array.length-1;
        while(low < high){
            int mid = (low+high)/2;
            if(target > array[mid]){       // for first occurrence we are moving toward right
                low = mid+1;
            }else {
                high = mid;
            }
        }
        if(array[low] == target){
            return low;
        }else {
            return -1;
        }
    }
    public static int lastOccurrence(int[] array, int target){
        int low = 0;
        int high = array.length-1;
        while (low < high){
            int mid = (low+high+1)/2;      // to avoid infinite loop in case of even number of element in array
            if(target < array[mid]){      // for last occurrence we are moving toward left
                high = mid-1;
            }else {
                low = mid;
            }
        }
        if(array[low] == target){
            return low;
        }else {
            return -1;
        }
    }
    public static int numberOfOccurrences(int [] arrray , int target){
        int first = firstOccurrence(arrray, target);
        int last  = lastOccurrence(arrray, target);
        if(first == -1){
            return 0;
        }else {
            return last - first +1;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,2,2,2,3,3,3,3,3,4,4,6,6,6,6,6,6,6,6,6,8,8,9,9,9,12,12,24,};
        int count = numberOfOccurrences(arr, 6);
        System.out.println(count);
    }
}
