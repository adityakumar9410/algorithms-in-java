public class FirstRepeatingChar {
    // Find first repeating character in string . e.g "abacbbs"  first repeating char is a
    public static char firstRepeatingChar(String str) {
        if(str==null ||  str.trim().isEmpty())
            return ' ';

        final int ENGLISH_ALPHABET = 26;
        int[] frequencies = new int[ENGLISH_ALPHABET];

        str = str.trim().replaceAll(" +", "").toLowerCase();
        for (var i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (frequencies[index] == 0)
                frequencies[index]++;
            else
                return str.charAt(i);
        }
        return ' ';
    }

    public static void main(String[] args) {

        System.out.println(firstRepeatingChar("     a  b   b   cds"));

    }
}
