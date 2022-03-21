public class ShellSort {
    private static final int[] array = new int[]{3, 5, 6, 8, 10, 1, 2, 4, 7, 9};
    public static void main(String[] args) {
        print(array);
        shellSort(array);
    }
    public static void print(int[] listToSort) {
        for (int el : listToSort) {
            System.out.print(el + ",");
        }
        System.out.println();
    }
    public static void swap(int[] listToSort, int iIndex, int jIndex) {
        int temp = listToSort[iIndex];
        listToSort[iIndex] = listToSort[jIndex];
        listToSort[jIndex] = temp;
    }
    public static void insertionSort(int[] arr, int startIndex, int increment) {
        for (int i = startIndex; i < arr.length; i = i + increment) {
            for (int j = Math.min(i + increment, arr.length - 1); j - increment >= 0; j = j - increment) {
                if (arr[j] < arr[j - increment]) {
                    swap(arr, j, j - increment);
                } else {
                    break;
                }
                print(arr);
            }
        }
    }
    public static void shellSort(int[] array) {
        int increment = array.length / 2;
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {
                insertionSort(array, startIndex, increment);
            }

            increment = increment / 2;
        }
    }
}
