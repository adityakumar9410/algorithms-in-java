import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingChar {

    public char findFirstRepeatingChar(String str){
        Set<Character>set=new HashSet<>();

        for(var ch : str.toCharArray()){
            if(set.contains(ch))
                return ch;

            set.add(ch);
        }
        return Character.MIN_VALUE;
    }

    public static void main(String[] args) {
        FirstRepeatingChar finder = new FirstRepeatingChar();
        var ch=   finder.findFirstRepeatingChar("abcgb");

        System.out.println(ch);
    }
}
