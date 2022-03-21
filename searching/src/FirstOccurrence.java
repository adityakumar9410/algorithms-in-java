public class FirstOccurrence {
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
    public static void main(String[] args) {
        int [] arr = { 1, 3, 3, 3, 4, 4, 5,6, 6, 6, 7, 7, 8,9};
        int []arr1={11,11};
        int index = firstOccurrence(arr1, 11);
        System.out.println(index);
    }
}
