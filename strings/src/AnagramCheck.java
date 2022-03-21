import java.util.Arrays;

public class AnagramCheck {
    //Check whether two strings are anagram
    //TC: O(nlogn)
    public static boolean areAnagram(String first , String second ){

        if(first==null || second==null || first.length() !=second.length())
            return false;

        var arr1=first.toCharArray();
        Arrays.sort(arr1);
        var arr2=second.toCharArray();
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);

    }

    //Method 2 : By counting frequencies of letter in each string
    //TC : O(N)
    public static boolean areAnagram2(String first, String second){
        if(first==null || second==null )
            return false;

        final int ENGLISH_ALPHABET=26;
        int[] frequencies=new int[ENGLISH_ALPHABET];

        first=first.toLowerCase();
        for(var i=0;i<first.length();i++)
            frequencies[first.charAt(i)-'a']++;

        second=second.toLowerCase();
        for(var i=0;i<second.length();i++){
            var index=second.charAt(i)-'a';
            if(frequencies[index]==0)
                return false;

            frequencies[index]--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(areAnagram2("abcd", "dbca"));
    }
}
