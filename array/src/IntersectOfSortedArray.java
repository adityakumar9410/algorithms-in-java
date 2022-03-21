import java.util.ArrayList;
import java.util.List;

// Given two array , find the intersection of arrays i.e common elements
public class IntersectOfSortedArray {
    public static void intersectionOfTwoSortedArray(int[] arr1, int[] arr2, List<Integer> intersect) {
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            while ((i < arr1.length - 1) && (arr1[i] == arr1[i + 1])) {
                i++;
            }
            while ((j < arr2.length - 1) && (arr2[j] == arr2[j + 1])) {
                j++;
            }
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                intersect.add(arr1[i]);
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 2, 3, 3, 4, 4, 7, 8};
        int[] arr2 = {1, 2, 2, 4, 4, 6, 6, 7, 8, 10};

        List<Integer> intersect = new ArrayList<>();

        intersectionOfTwoSortedArray(arr1, arr2, intersect);
        System.out.println(intersect);   //2,4,7,8
    }

}