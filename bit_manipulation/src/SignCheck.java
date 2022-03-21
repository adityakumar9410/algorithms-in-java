public class SignCheck {

   /* Given two number check whether tey have opposite sign
    All negative num represented as 2's complement and has leading 1 in their binary representation
    All positive num leading 0 in binary
    So  XOR of both num will be -ve*/

    public static boolean hasOppositeSign(int x, int y){
        return ((x^y)<0);
    }

    public static void main(String[] args) {
        System.out.println(hasOppositeSign(-7, 7));
    }
}
