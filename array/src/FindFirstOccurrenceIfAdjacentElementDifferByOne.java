//Find first occurrence of element in array if adjacent element differ by one
public class FindFirstOccurrenceIfAdjacentElementDifferByOne {
          public static int findFirstOccurrenceIfAdjacentElementDifferByOne(int[] array, int value){
              int start = 0;
              while (start < array.length){
                  if(array[start] == value)
                      return start;
                  else{
                      int diff  = Math.abs(array[start] -value);
                      start = start +diff;
                  }
              }
              return -1;
          }

    public static void main(String[] args) {
        int[] arr = {7,6,7,6,7,6,5,3,5,3,2,1,2,3,4,5};
        System.out.println(findFirstOccurrenceIfAdjacentElementDifferByOne(arr, 2));
    }
}
