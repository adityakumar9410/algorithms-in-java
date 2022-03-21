import java.util.Stack;

public class ReverseString {
    //Using stack
    //TC : O(N)  || SC : O(n)
    public static void reverseStringUsingStack(String str){
        StringBuilder s= new StringBuilder();
        Stack<Character>charStack=new Stack<>();
        for(var ch: str.toCharArray())
            charStack.push(ch);

        while (!charStack.isEmpty()){
            s.append(charStack.pop());
        }
        System.out.println(s.toString());
    }

    //Using for Loop  TC : O(n)  || SC : O(1)
    public static String reverseString(String str){
        if(str==null)
            return"";
        StringBuilder reversed= new StringBuilder();
        for(var i=str.length()-1;i>=0;i--)
            reversed.append(str.charAt(i));

        return reversed.toString();
    }

    public static void main(String[] args) {
        reverseStringUsingStack("ABC");

        System.out.println(reverseString("ABC"));
    }
}
