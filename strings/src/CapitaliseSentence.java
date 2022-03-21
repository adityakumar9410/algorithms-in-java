public class CapitaliseSentence {
    // Capitalise first letter of every word in a sentence
    public static String capitalise(String sentence){

        if(sentence==null ||  sentence.trim().isEmpty())
            return "";

        String[] words=sentence.trim().replaceAll(" +"," ").split(" ");
        for(var i=0;i<words.length;i++){
           words[i]= words[i].substring(0, 1).toUpperCase()+words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(capitalise("a morning walk    is good for health      "));
    }
}
