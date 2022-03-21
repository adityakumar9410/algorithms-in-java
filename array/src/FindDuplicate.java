/*We have n+1 number given in 1 To n range find duplicate*/
public class FindDuplicate {
    public static int findDuplicateValue(int[] array){
        if(array.length == 0)
            return -1;

        int i=0;
        while( i  < array.length){
            if(array[i] != array[array[i]-1]){
                int finalIndex = array[i]-1;
                int temp = array[i];
                array[i] = array[finalIndex];
                array[finalIndex] = temp;
            }else {
                i++;
            }
        }
        return array[array.length-1];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3,5,1,2,4};
        System.out.println(findDuplicateValue(arr));
    }

}
