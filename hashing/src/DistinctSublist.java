import java.util.HashMap;
import java.util.Map;

public class DistinctSublist {

    /*K-Distinct Sublists
Given a list of integers nums and an integer k, return the number of sublists such
that there's exactly k distinct numbers in the sublist.
Constraints
k ≤ n ≤ 100,000 where n is the length of nums
Example 1
Input
nums = [1, 1, 2, 3]
k = 2
Output
3
Explanation
We have the following sublists which have exactly 2 distinct numbers: [1, 1, 2], [1, 2], [2, 3]

*/
    /*General Approach: Two pointer Sliding Window
      maintain a sliding window where a is the starting point of the sliding window,
      b is the first index where it satisfy that the sublist between a and b has exactly k distinct elements.
       c is the last index where it satisfy that the sublist between a and c has exactly k distinct elements.
       [1,1,2,2,3] initially a=0, b=2,c=3 th index
      then for all sublist starting at index a, there are c+1-b sublits that are valid.
      Time complexity: O(N)
      Space complexity: O(N)*/

    public static int solve(int[] nums, int k) {
        final int N = nums.length;
        Map<Integer, Integer> counts = new HashMap<>(N);
        int res = 0;
        for (int a = 0, b = -1, c = -1, kinds = 0; a != N; a++) {
            while (b + 1 != N && kinds < k) {
                b++;
                int prev = counts.getOrDefault(nums[b], 0);
                if (0 == prev)
                    kinds++;
                counts.put(nums[b], prev + 1);
            }
            c = Math.max(c, b);
            while (c + 1 != N && counts.containsKey(nums[c + 1])) {
                c++;
            }
            if (kinds == k)
                res += (c + 1 - b);
            if (kinds < k)
                break;

            {
                int prev = counts.get(nums[a]) - 1;
                if (prev == 0) {
                    counts.remove(nums[a]);
                    kinds--;
                } else
                    counts.put(nums[a], prev);
            }
        }
        return res;
    }

  /*  public int solve1(int[] nums, int k) {
        // distinct k = distinct(k) - distinct(k-1)
        return distinctK(nums, k) - distinctK(nums, k - 1);
    }

    // helper for variable length sliding window
    private int distinctK(int[] nums, int k) {
        int ans = 0, left = 0;
        Window window = new Window();
        for (int right = 0; right < nums.length; right++) {
            window.add(nums[right]);
            // sliding window constraints
            while (window.difference() > k) window.remove(nums[left++]);
            // subarray length
            ans += right - left + 1;
        }
        return ans;
    }
}
class Window {
    Map<Integer, Integer> map;
    int count; // tracks distinct count

    public Window() {
        map = new HashMap<>();
        count = 0;
    }

    public void add(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
        if (map.get(x) == 1)
            count++;
    }

    public void remove(int x) {
        map.put(x, map.get(x) - 1);
        if (map.get(x) == 0)
            count--;
    }

    int difference() {
        return count;
    }*/

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 4, 5};
        System.out.println(solve(nums, 2));
    }
}
