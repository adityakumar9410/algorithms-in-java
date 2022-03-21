import java.util.ArrayList;
import java.util.List;

//Find all sub-array with multiplication of its elements less than given number
//T.C = O(n^2)
//S.C = O(n)
public class SubArrayWithProductLessThanGivenNumber {
    public static List<List<Integer>>findAllSubArrayWithProductOfItsElementsLessThanGivenNumber(int [] array, int value){
        int productOfElements = 1;
        int start = 0;
        List<List<Integer>> allSubArray  = new ArrayList<>();

        for(int i=0; i<array.length; i++){
            productOfElements = productOfElements*array[i];

            while (productOfElements >= value){
                productOfElements = productOfElements/array[start];
                start++;
            }

            List<Integer> list = new ArrayList<>();
            for(int j=i; j>=start; j--){
                list.add(0, array[j]);
                allSubArray.add(new ArrayList<>(list));
            }
        }
        return allSubArray;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,5,3,6};
        System.out.println(findAllSubArrayWithProductOfItsElementsLessThanGivenNumber(arr,45));
    }
}
