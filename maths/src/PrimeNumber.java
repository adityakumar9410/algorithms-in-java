import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {
    public static boolean isPrime(int number){  // Time : O(n^1/2)
        int n = (int)Math.sqrt(number); //Because one prime factor lies below n = sqrt(number) and another lies after n
        for(int i=2; i<= n; i++){
            if(number%i == 0)
                return false;
        }
        return true;
    }

    // Find all prime number up to n
    public static List<Integer> findAllPrimeNumber(int n){  // Time : O(n^3/2)
        List<Integer> allPrimes = new ArrayList<>();
        for(int i=2; i<=n; i++){
            if(isPrime(i))
                allPrimes.add(i);
        }
        return allPrimes;
    }
    // Find all prime number up to n using sieve of eratosthenes
    public static List<Integer> sieveOfEratosthenes(int num){
        List<Integer> allPrimes = new ArrayList<>();
        int[] primes = new int[num+1];
        for(int i=0; i<=num; i++)
            primes[i] = 1;
        primes[0] = primes[1] = 0;
        int n= (int)Math.sqrt(num);
        for(int i=2; i<=n; i++){     //All multiple of 2,3,5 etc set to zero
            if(primes[i] == 1){
                for(int j=2; i*j<=num; j++)
                    primes[i*j]=0;
            }
        }
        for(int i=2; i<=num; i++){
            if(primes[i] == 1)
                allPrimes.add(i);
        }
        return allPrimes;
    }

    public static void main(String[] args) {
		
		System.out.println(findAllPrimeNumber(45));

        System.out.println(sieveOfEratosthenes(19));
    }
}
