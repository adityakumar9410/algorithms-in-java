import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPermutation {
    /*M-1  Creating extra array to store new array
     TC : O(n^2*n!) time ||SC : O(n*n!)
    Avg. TC : O(n*n!) || SC : O(n*n!) */

    public static List<List<Integer>> findPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        findPermutations(array, new ArrayList<>(), permutations);
        return permutations;
    }

    private static void findPermutations(List<Integer> array, List<Integer> currentPerm, List<List<Integer>> permutations) {
        if (array.size() == 0 && currentPerm.size() > 0)
            permutations.add(currentPerm);
        else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> newArray = new ArrayList<>(array);
                newArray.remove(i);
                List<Integer> newPermutation = new ArrayList<>(currentPerm);
                newPermutation.add(array.get(i));
                findPermutations(newArray, newPermutation, permutations);
            }
        }
    }
    //M-2 By swapping in place
    //TC : O(n*n!)   || SC : O(n*n!)
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutations(0, array, permutations);
        return permutations;
    }
    private static void getPermutations(int i, List<Integer> array, List<List<Integer>> permutations) {
        if (i == array.size() - 1)
            permutations.add(new ArrayList<>(array));
        else {
            for (int j = i; j < array.size(); j++) {
                swap(array, i, j);
                getPermutations(i + 1, array, permutations);
                swap(array, i, j);
            }
        }
    }
    public static void swap(List<Integer> array, int i, int j) {
        Integer tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }
    public static void main(String[] args) {
        System.out.println(findPermutations(Arrays.asList(1, 2, 3)));
        System.out.println(getPermutations(Arrays.asList(1, 2, 3)));
    }
}