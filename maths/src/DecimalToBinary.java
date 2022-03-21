import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*A number given in decimal form , convert it in binary*/
public class DecimalToBinary {
    public static List<Integer> convertToBinary(int number){
        List<Integer> list = new ArrayList<>();
        if(number == 0){
            list.add(0);
        }
        while(number>0){
            int rem = number%2;
            list.add(rem);
            number = number/2;
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(convertToBinary(16));
    }
}
