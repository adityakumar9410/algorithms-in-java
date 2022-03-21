import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static List<String> findPermutations(String str){
        List<String> permutations=new ArrayList<>();
        findPermutations(str, "", permutations);
        return permutations;
    }
    private static void findPermutations(String str, String currPerm, List<String> permutations) {
        if(str.length()==0 && currPerm.length()>0)
            permutations.add(currPerm);
        else {
            for (int i=0;i<str.length();i++){
               String newString= str.substring(0,i)+str.substring(i+1);
               String newPermutation= currPerm+ str.charAt(i);
               findPermutations(newString, newPermutation, permutations);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(findPermutations("abc"));
    }
}
