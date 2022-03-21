import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class PowerSet {
    //Recursive  TC: O((2^n)*n)  || SC: O((2^n)*n)
    public static List<List<Integer>> findPowerSet(List<Integer> array) {
        return findPowerSet(array, array.size() - 1);
    }
    private static List<List<Integer>> findPowerSet(List<Integer> array, int index) {
        if (index < 0) {
            List<List<Integer>> emptySet = new ArrayList<>();
            emptySet.add(new ArrayList<>());
            return emptySet;
        }
        int element = array.get(index);
        List<List<Integer>> subsets = findPowerSet(array, index - 1);
        int length = subsets.size();
        for (int i = 0; i < length; i++) {
            List<Integer> currentSubset = new ArrayList<>(subsets.get(i));
            currentSubset.add(element);
            subsets.add(currentSubset);
        }
        return subsets;
    }

    //Iterative    TC: O((2^n)*n)  || SC: O(( 2^n)*n)
    public static List<List<Integer>> powerSet(List<Integer> array) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (Integer ele : array) {
            int length = subsets.size();
            for (int i = 0; i < length; i++) {
                List<Integer> currentSubset = new ArrayList<>(subsets.get(i));
                currentSubset.add(ele);
                subsets.add(currentSubset);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        System.out.println(powerSet(Arrays.asList(1, 2, 3)));
        System.out.println(findPowerSet(Arrays.asList(1, 2, 3)));
    }


}
