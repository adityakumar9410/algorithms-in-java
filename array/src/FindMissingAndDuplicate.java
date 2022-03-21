import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FindMissingAndDuplicate {
    /*find all missing and duplicate numbers between 1 to n range
     * e.g  arr=[2,3,4,4,6,2] ,  n=6   here missing =[1,5], duplicate =[2,4]*/
    public static List<List<Integer>> findAllMissingAndDuplicates(int[] array) {
        if (array.length == 0)
            return new ArrayList<>();
        int i = 0;
        while (i < array.length) {
            if (array[i] != array[array[i] - 1]) { // This places element to right position
                int otherIndex = array[i] - 1;
                int temp = array[i];
                array[i] = array[otherIndex];
                array[otherIndex] = temp;
            } else
                i++;
        }
        List<Integer> missingValues = new ArrayList<>();
        List<Integer> duplicateValues = new ArrayList<>();
        for (i = 0; i < array.length; i++) { // This checks whether desired number is present at correct position
            if (array[i] != i + 1) {
                missingValues.add(i + 1);
                duplicateValues.add(array[i]);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(missingValues);
        result.add(duplicateValues);
        return result;
    }

    private static int[] getArray(int capacity) {
        int[] array = new int[capacity];
        System.out.println("Enter   " + capacity + "   Integers values between 1 to " + capacity);
        for (int i = 0; i < array.length; i++) {
            Scanner scanner = new Scanner(System.in);
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter capacity of array");
        int capacity = scanner.nextInt();

        int[] arr = getArray(capacity);

        System.out.println(findAllMissingAndDuplicates(arr));

    }

}
