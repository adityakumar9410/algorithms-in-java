import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static List<String> wordSplit(String str, List<String> wordsList) {
        List<String> output = new ArrayList<>();
        return wordSplit(str, wordsList, output);
    }

    private static List<String> wordSplit(String str, List<String> wordsList, List<String> output) {
        for (String word : wordsList) {
            if (str.startsWith(word)) {
                output.add(word);
                String s = str.substring(word.length());
                return wordSplit(s, wordsList, output);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(wordSplit("ilovedogsjohn", Arrays.asList("i", "m", "dogs", "lover", "love", "john")));
    }
}
