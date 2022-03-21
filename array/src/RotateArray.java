public class RotateArray {


    //Method 1:Rotate array by reversal method  TC:O(N)  || SC:O(1)
    //Left rotate array by d elements
    public static void leftRotateByReversal(int[] arr, int d) {
        if (d == 0)
            return;

        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, arr.length - 1);
        reverseArray(arr, 0, arr.length - 1);
    }

    //Right rotate array by d elements  TC: O(n) || SC:O(1)
    public static void rightRotateByReversal(int[] arr, int d) {
        if (d == 0)
            return;

        reverseArray(arr, 0, arr.length - 1);
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, arr.length - 1);

    }

    private static void reverseArray(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    //Method 2: Using rotateByOne method d times
    //TC:O(n*d) ||SC:O(1)
    public static void leftRotateArray(int[] arr, int d) {
        int n = arr.length;
        for (int i = 0; i < d; i++)
            leftRotateByOne(arr);
    }

    private static void leftRotateByOne(int[] arr) {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < arr.length - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
    }


    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + "  ");
        System.out.println();
    }

    //Method 3: Rotate array by juggling method
    //We first divide the array in gcd(d,n) number of set . Then move by left by taking d step
    //TC:O(n) ||SC:O(1)
    public static void leftRotateByJuggling(int[] arr, int d) {
        int n=arr.length;
        /* To handle if d >= n */
        d = d % n;
        int i, j, k, temp;
        int g_c_d = gcd(d, n);
        for (i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }
    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 6, 8, 9, 23, 45};
        printArray(arr);
        // leftRotateByReversal(arr,2);
        // rightRotateByReversal(arr,2);

        //leftRotateArray(arr, 2);
        leftRotateByJuggling(arr,3);
        printArray(arr);

    }
}
