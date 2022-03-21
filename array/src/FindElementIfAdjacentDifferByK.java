/*Find the first occurrence of element if adjacent differ by atmost k*/
public class FindElementIfAdjacentDifferByK {
    public static int findWhereAdjacentDifferByAtMostK(int[] array, int k, int target){
        int start = 0;
        while (start < array.length){
            if(array[start] == target)
                return start;
            else{
                int diff  = Math.abs(array[start] -target)/k;
                diff = Math.max(1, diff);
                start = start +diff;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {70,60,80,90,130,120,110};
        System.out.println(findWhereAdjacentDifferByAtMostK(arr, 20,110));
    }
}
