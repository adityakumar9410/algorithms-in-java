public class MaxRopeCuts {

    //Find the max cuts of rope of length if each piece can be from set {a,b,c}
    //TC: O(3^n)  || SC: O(n)
    public static int maxCuts(int n ,int a,int b, int c){
        if(n==0)
            return 0;
        if(n<0)
            return -1;

        int res=  Math.max(Math.max(maxCuts(n-a, a,b,c), maxCuts(n-b,a,b,c)), maxCuts(n-c,a,b,c));
        return res+1;
    }

    public static void main(String[] args) {
        System.out.println(maxCuts(23,11,12,9));
    }
}
