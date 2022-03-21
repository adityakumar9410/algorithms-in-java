import java.util.Arrays;
import java.util.List;

public class SingleNumber {
    //Given a list of numbers , all numbers appears three times except one . Find the single number
    //TC :O(n) || SC:O(1)
    public static int singleNumber(List<Integer> numbs) {
        int ones = 0, twos = 0;
        int threes;
        for (int i = 0; i < numbs.size(); i++) {
            twos |= ones & numbs.get(i);
            ones ^= numbs.get(i);
            threes = ones & twos;
            // if num[i] appears three times then we will return ones.
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
    public static void main(String[] args) {
        System.out.println(singleNumber(Arrays.asList(0 ,2,0,0)));

    }


}
