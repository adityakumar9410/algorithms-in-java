public class LinearSearch {

    //TC : O(n)
    public static int linearSearch(int[] array , int target){
        for(int i=0;i<array.length;i++){
            if(array[i]==target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8, 9, 13, 15, 23, 45, 56, 98};
        System.out.println(linearSearch(arr,23));
    }
}
