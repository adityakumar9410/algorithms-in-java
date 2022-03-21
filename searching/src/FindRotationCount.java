/*Given a circular array which are sorted and rotated . find rotation of array
* eg.[12,13,14,15,16,18,2,6,8,9] , here index of min element will be the rotation count of array
* min element have previous and next both number greater than it.eg 2 has 18 and 6 both greater than 2*/
public class FindRotationCount {
    public static int findRotationCount(int[] array, int n){    // Time : O(logN)
        int low = 0;
        int high = array.length-1;
        while (low <= high){
            int mid = (low+high)/2;
            if(array[low] <=array[high])   // Array is already sorted in this case
                return low;

            int next = (mid+1)%n;
            int prev = (mid+n-1)%n;

            if(array[mid] <=array[next] && array[mid] <=array[prev])
                return mid;
            if(array[mid] <= array[high])
                high = mid-1;
            if(array[mid] >= array[low])
                low = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {2,4,7};
        int index = findRotationCount(arr, arr.length);
        System.out.println("Array is rotated  : "+index+"  times ");
    }

}
