import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*Give an array with elements in range 1 to n . find one missing - duplicate pair*/
public class CorruptPair {
    public static List<Integer> findCorruptPair(int[] array) {
        if (array.length == 0)
            return new ArrayList<>();
        int i = 0;
        while (i < array.length) {
            if (array[i] != array[array[i] - 1]) {
                int finalIndex = array[i] - 1;
                int temp = array[i];
                array[i] = array[finalIndex];
                array[finalIndex] = temp;
            } else
                i++;
        }
        for (i = 0; i < array.length; i++) {
            if (array[i] != i + 1)
                return new ArrayList<>(Arrays.asList(i + 1, array[i]));
        }
        return new ArrayList<>();
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 3, 4};
        System.out.println(findCorruptPair(arr));
    }
}
