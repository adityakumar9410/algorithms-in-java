import java.util.Stack;
public class LeaderInArray {
    //If all the element on right side of an element is smaller than current element  then that element is leader
    //TC :O(n) || SC: O(1)
    public static void findLeaderInArray(int[] arr) {
        int n = arr.length;
        int max = arr[n - 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                stack.push(arr[i]);
                max = arr[i];
            }
        }
        while (!stack.empty()) {
            int num = stack.pop();
            System.out.print(num + "  ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 20, 15, 8, 3};
        findLeaderInArray(arr); //20 , 15, 8, 3
    }
}
