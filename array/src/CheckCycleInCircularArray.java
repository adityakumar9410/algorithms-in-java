public class CheckCycleInCircularArray {
    //Given a circular  array , check whether it contains cycle. E.g. array=[2,-1,1,2,-1] has cycle.
    //Conditions: array[i]=jump, direction(forward +, backward -),  cycle should be in one direction, origin can be any point
    //cycle should contain more than one point
    public static boolean checkIfCircularArrayContainCycle(int[] array) {
        if (array.length <= 1)
            return false;
        for (int i = 0; i < array.length; i++) {
            //Take two pointer , slow will take one step and fast will take two step. Each step will equal to array[i]
            int slow, fast;
            slow = fast = i;
            boolean ifForward = array[i] > 0;   //If we are moving forward or not
            do {
                slow = getNextIndex(array, slow, ifForward);
                fast = getNextIndex(array, fast, ifForward);
                if (fast != -1) {
                    fast = getNextIndex(array, fast, ifForward);
                }
            }while(slow!=-1 && fast != -1 && slow != fast);

            if (slow != -1 && slow==fast){
                return  true;
            }
        }
        return false;
    }
    private static int getNextIndex(int[] arr, int index, boolean ifForward) {
        boolean direction = arr[index] >= 0;
        if (direction != ifForward)         //  If direction changes
            return -1;
        int nextIndex = (index + arr[index]) % arr.length;
        if (nextIndex < 0)                                       // In case of arr[index] is negative
            nextIndex = nextIndex + arr.length;
        if (nextIndex == index)    // when there is only one element in cycle
            nextIndex=-1;
        return nextIndex;
    }

    //Method : 2

    public static void main(String[] args) {
        int[] arr1 = {2, -1, 1, 2, -1};
        int[] arr2 = {4, 1, 1, 1};
        System.out.println(checkIfCircularArrayContainCycle(arr1)); //true
        System.out.println(checkIfCircularArrayContainCycle(arr2)); //false
    }
}
