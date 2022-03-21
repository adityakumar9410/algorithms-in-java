import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    //Find length of longest increasing subsequence
    //Given [7,1,4,8,11,2,14,3] Ans is [1,4,8,11,14] ==5.
    //Bottom Up DP  TC:O(n^2)  || SC:O(n)
    public int findLISLengthDP(int[] array) {
        int[] lis = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            lis[i] = 1;
        }
        int maxLISLength = 1;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                    maxLISLength = Math.max(maxLISLength, lis[i]);
                }
            }
        }
        return maxLISLength;
    }

    //Build seq.
    // O(n^2) time | O(n) space
    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        int[] sequences = new int[array.length];
        Arrays.fill(sequences, Integer.MIN_VALUE);
        int[] lengths = new int[array.length];
        Arrays.fill(lengths, 1);
        int maxLengthIdx = 0;
        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            for (int j = 0; j < i; j++) {
                int otherNum = array[j];
                if (otherNum < currentNum && lengths[j] + 1 >= lengths[i]) {
                    lengths[i] = lengths[j] + 1;
                    sequences[i] = j;
                }
            }
            if (lengths[i] >= lengths[maxLengthIdx]) {
                maxLengthIdx = i;
            }
        }
        return buildSequence(array, sequences, maxLengthIdx);
    }

    private static List<Integer> buildSequence(int[] array, int[] sequences, int currentIdx) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (currentIdx != Integer.MIN_VALUE) {
            sequence.add(0, array[currentIdx]);
            currentIdx = sequences[currentIdx];
        }
        return sequence;
    }

    //Method 2:TC:O(NlogN) || SC:O(N)

    // O(nlogn) time | O(n) space
    public static List<Integer> longestIncreasingSubsequence1(int[] array) {
        int[] sequences = new int[array.length];
        int[] indices = new int[array.length + 1];
        Arrays.fill(indices, Integer.MIN_VALUE);
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int newLength = binarySearch(1, length, indices, array, num);
            sequences[i] = indices[newLength - 1];
            indices[newLength] = i;
            length = Math.max(length, newLength);
        }
        return buildSequence(array, sequences, indices[length]);
    }
    public static int binarySearch(int startIdx, int endIdx, int[] indices, int[] array, int num) {
        if (startIdx > endIdx)
            return startIdx;
        int middleIdx = (startIdx + endIdx) / 2;
        if (array[indices[middleIdx]] < num) {
            startIdx = middleIdx + 1;
        } else {
            endIdx = middleIdx - 1;
        }
        return binarySearch(startIdx, endIdx, indices, array, num);
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};
        LongestIncreasingSubsequence lcs = new LongestIncreasingSubsequence();
        System.out.println(lcs.findLISLengthDP(arr));

        System.out.println(longestIncreasingSubsequence(arr));
    }
}
