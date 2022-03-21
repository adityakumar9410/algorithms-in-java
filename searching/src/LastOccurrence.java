public class LastOccurrence {
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

    public static void main(String[] args) {
        int [] arr = { 1, 3, 3, 3, 4, 4, 5,6, 6, 6, 7, 7, 8,9};
        int index = lastOccurrence(arr, 6);
        System.out.println(index);
    }

}
