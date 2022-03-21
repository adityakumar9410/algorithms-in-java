public class OddOccurringElement {
    // Given an array of integer in while only one element appear odd number of time, find  the number
    //Sol : XOR operation properties ->  5^0=5, 5^5=0
    // so if number appear even number of time then it will cancel out each other
    //TC : O(n) || SC : O(1)
    public static int findOddOccurringElement(int[] arr){
        int result =0;
        for(int i=0;i<arr.length;i++){
            result^=arr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr={2,1,4,3,1,6,2,4,6};
        System.out.println(findOddOccurringElement(arr));
    }

}
