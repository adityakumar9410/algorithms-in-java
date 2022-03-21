public class StringRotation {

    //Check whether two string are rotation of each other

    public static boolean areRotations(String str1, String str2) {

        if (str1 == null || str2 == null)
            return false;

        return (str1.length() == str2.length() && (str1 + str2).contains(str2));
    }

    public static void main(String[] args) {
        System.out.println(areRotations("abcd", "bcda"));
    }
}
