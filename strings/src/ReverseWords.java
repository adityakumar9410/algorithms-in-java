public class ReverseWords {

    //Reverse the words of sentence
    public static String reverseWords(String sentence ){

        if(sentence==null)
            return "";
        String [] words=sentence.trim().split(" ");
        StringBuilder reversed = new StringBuilder();

        for(var i=words.length-1;i>=0;i--)
            reversed.append(words[i]).append(" ");

        return reversed.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("I love you     "));
    }
}
