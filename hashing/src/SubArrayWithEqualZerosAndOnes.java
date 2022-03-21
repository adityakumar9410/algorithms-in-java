import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrayWithEqualZerosAndOnes {

    //Given an array of 0's and 1's find max length of  sub array which has number of  equal zero's and one's

    //Method-1 : Brute force   TC: O(n^2)  || SC : O(1)
    public static int findLengthSubArray(List<Integer>arr){

        int maxLength=0;
        for (int i = 0; i < arr.size(); i++) {
            int zeroCount=0;
            int onesCount=0;
            int lengthSubArray;
            for (int j = i; j < arr.size(); j++) {
                if(arr.get(j)==0)
                    zeroCount++;
                if(arr.get(j)==1)
                    onesCount++;

                lengthSubArray = j - i + 1;
                if ((zeroCount==onesCount) && lengthSubArray>=2) {
                    if(lengthSubArray>maxLength)
                        maxLength=lengthSubArray;
                }
            }
        }
        return maxLength;
    }

    //Method-2  : Hashing     TC: O(n)  || SC:



    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1,1,1,1,0, 0,1,1,1,1,0,0));
        System.out.println(findLengthSubArray(array));
    }
}
