public class TowerOfHanoi {

    //Move all disc from A to C    TC:O(2^n)
    public static void TOH(int n , String  A, String  B, String C){
        if (n > 0) {
            TOH(n-1, A,C, B);
            System.out.println("Move disc from  "+A+" to "+ C);
            TOH(n-1, B, A, C);
        }
    }

    public static void main(String[] args) {
        TOH(3, "A","B","C");
    }
}
