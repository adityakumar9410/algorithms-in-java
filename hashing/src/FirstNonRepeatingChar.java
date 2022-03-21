import java.util.HashMap;
import java.util.Map;
public class FirstNonRepeatingChar {
    public char findFirstNonRepeatingChar(String str){
        Map<Character, Integer> map=new HashMap<>();

        var chars=str.toCharArray();
        for(var ch : chars ){
            var count = map.getOrDefault(ch, 0);
            map.put(ch, count+1);
        }

        for(var ch : chars)
            if(map.get(ch)==1)
                return ch;

        return Character.MIN_VALUE;
    }
    public static void main(String[] args) {
        FirstNonRepeatingChar  finder= new FirstNonRepeatingChar();
        var ch=  finder.findFirstNonRepeatingChar("aab");
        System.out.println(ch);
    }
}


