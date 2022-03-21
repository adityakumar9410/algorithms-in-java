import java.util.HashSet;
import java.util.Set;

// Find first repeating number in an array
public class FirstRepeating {
    public static int firstRepeatingNumberInArray(int[] array) {
        Set<Integer> set = new HashSet<>();
        int firstRepeating = -1;

        for (int i = array.length - 1; i >= 0; i--) {
            if (set.contains(array[i]))
                firstRepeating = array[i];
            else
                set.add(array[i]);
        }
        return firstRepeating;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 77, 3, 5, 7, 4};
        System.out.println(firstRepeatingNumberInArray(arr));
    }

}
