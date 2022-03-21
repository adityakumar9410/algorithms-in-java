import java.util.ArrayList;
import java.util.List;
/*Find all factor of number n*/
public class FindAllFactor {
    public static List<Integer> findAllFactors(int num){  // Time : O(n^1/2)
        List<Integer> factors = new ArrayList<>();
        int n= (int)Math.sqrt(num);
        for(int i=1; i<n; i++){
            if(num%i == 0)
                factors.add(i);
        }
        for(int i=n; i>=1; i--){
            if(num%i == 0)
                factors.add(num/i);
        }
        return factors;
    }

    public static void main(String[] args) {
        System.out.println(findAllFactors(36));
    }
}
