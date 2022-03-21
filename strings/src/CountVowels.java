import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountVowels {
    // TC : O(n*5)  || SC: O(5)
    public static int countVowels(String str){
        if(str==null)
            return 0;
        int count=0;
        String vowels="aeiou";
        for(var ch : str.toLowerCase().toCharArray()){
            if(vowels.indexOf(ch)!=-1)
                count++;
        }
        return count;
    }

    //Using Set to store vowels  TC :O(n)
    public static int countVowelsUsingSet(String str){
        if(str==null)
            return 0;

        int count=0;

        Character[] charArr={'a','e','i','o','u'};
        Set<Character>vowels=new HashSet<>(Arrays.asList(charArr));

        for(var ch : str.toLowerCase().toCharArray()){
            if(vowels.contains(ch))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int cnt=countVowelsUsingSet("hello world");
        int count=countVowels("hello world");
        System.out.println(cnt);
        System.out.println(count);
    }
}


