import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// find quadruple whose sum is equal to target sum   TC:O(n^3)
public class FindQuadruple {
    public static List<List<Integer>> findQuadruple(int[] array, int targetSum) {
        Arrays.sort(array);
        List<List<Integer>> allQuadruple = new ArrayList<>();

        for (int i = 0; i < array.length - 3; i++) {
            for (int j = i + 1; j < array.length - 2; j++) {
                int sum = targetSum - (array[i] + array[j]);
                int start = j + 1;
                int end = array.length - 1;
                while (start < end) {
                    int t = array[start] + array[end];
                    if (t == sum) {
                        allQuadruple.add(Arrays.asList(array[start], array[end], array[i], array[j]));
                        start++;
                        end--;
                    } else if (t < sum)
                        start++;
                    else
                        end--;
                }
            }
        }
        return allQuadruple;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 4, -2, -1, 3};
        System.out.println(findQuadruple(arr, 3));
    }
}
