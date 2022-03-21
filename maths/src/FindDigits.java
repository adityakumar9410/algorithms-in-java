import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class FindDigits {
    /*Find digits of given number*/
    public static List<Integer>  findDigits(int number){
        List<Integer> list = new ArrayList<>();
        if(number == 0){
            list.add(0);
        }
        while (number>0){
            int remainder = number%10;
            list.add(remainder);
            number = number/10;
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findDigits(6879037));
    }
}
