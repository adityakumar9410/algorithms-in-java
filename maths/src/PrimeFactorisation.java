/*Find all prime factorisation of number n*/
public class PrimeFactorisation {
    public static void primeFactorisation(int num){
        int n = (int)Math.sqrt(num);
        for(int i=2; i<=n; i++){
            if(num%i==0){
                int count = 0;
                while (num%i==0){
                    num=num/i;
                    count++;
                }
                System.out.print(i+"^"+count+"   ");
            }
        }
        if(num!=1)
            System.out.print(num+"^"+1);
    }

    public static void main(String[] args) {
        primeFactorisation(105);
    }
}
