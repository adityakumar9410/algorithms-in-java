public class ReverseString {

    public static String reverseStringRecursive(String str){
        if(str.length()<=1)
            return str;
        String s= str.substring(1);
       String s0=String.valueOf(str.charAt(0));
       return reverseStringRecursive(s)+s0;
    }
    public static String  reverseStringIterative(String str){
        char[] charArr=str.toCharArray();
        int start=0;
        int end=str.length()-1;
        while (start<end){
            char temp=charArr[start];
            charArr[start]=charArr[end];
            charArr[end]=temp;
            start++;
            end--;
        }
        return new String(charArr);
    }
    public static void main(String[] args) {
        System.out.println(reverseStringRecursive("adityakumaryadav"));
       // System.out.println(reverseStringIterative("adityakumaryadav"));
    }
}
