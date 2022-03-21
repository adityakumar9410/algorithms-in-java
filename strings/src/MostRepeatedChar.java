import java.util.HashMap;
import java.util.Map;
public class MostRepeatedChar {
    public static char getMaxOccurringCharacter(String str){
        if (str==null || str.isEmpty() )
            throw new IllegalArgumentException();
        Map<Character, Integer>freq=new HashMap<>();
        for(var ch : str.toCharArray()){
            if(freq.containsKey(ch))
                freq.replace(ch, freq.get(ch)+1);
            else
                freq.put(ch, 1);
        }
        int max=0;
        char  ch=' ';
        for(Map.Entry<Character, Integer>entry: freq.entrySet()){
            Character key=entry.getKey();
            Integer value= entry.getValue();
            if(value>max){
                max=value;
                ch= key;
            }
        }
        return ch;
    }
    public static char getMostOccurringChar(String str){
        if (str==null ||  str.isEmpty() )
            throw new IllegalArgumentException();

        final int ASCII_SIZE=256;
        int[] freq= new int[ASCII_SIZE];

        for (var ch : str.toCharArray())
            freq[ch]++;

        int max=0;
        char result = ' ';
        for(var i=0;i<freq.length;i++){
            if(freq[i]>max) {
                max = freq[i];
                result=(char)i;
            }
        }
        return result;
    }
    public static void main(String[] args) {
          var  c=  getMostOccurringChar("Trees are beautiful ");
          System.out.println(c);
          System.out.println(getMaxOccurringCharacter("Trees are beautiful "));
    }
}
