public class JosephusProblem {

     // Kill Kth person in every iteration and find survivor
    public static int findSurvivor(int n, int k){
        if(n==1)
            return n;

        return (findSurvivor(n-1, k)+k-1)%n+1;
    }

    public static void main(String[] args) {
        System.out.println(findSurvivor(8,2));
    }
}
