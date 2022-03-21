import java.util.*;

public class SumOfDivided {
    /*Given an array of positive or negative integers I= [i1,..,in] you have to produce a sorted array P of the form
    [ [p, sum of all ij of I for which p is a prime factor (p positive) of ij] ...]
    P will be sorted by increasing order of the prime numbers.
     The final result has to be given as a string in Java, C#, C, C++ and as an array of arrays in other languages.
   Example:
    I = {12, 15}; // result = "(2 12)(3 27)(5 15)"
    [2, 3, 5] is the list of all prime factors of the elements of I, hence the result.
   Notes:
    It can happen that a sum is 0 if some numbers are negative!
    Example: I = [15, 30, -45] 5 divides 15, 30 and (-45) so 5 appears in the result, the sum of the numbers for which 5 is a factor is 0 so we have [5, 0] in the result amongst others.
*/
    public static String sumOfDivided(int[] l) {
        Map<Integer, List<Integer>>map=new TreeMap<>();
        for (int i=0;i<l.length;i++){
            int number=Math.abs(l[i]);
            List<Integer>primeFactors=getPrimeFactors(number);
            for(int factor:primeFactors){
                if (map.containsKey(factor)){
                    var list=map.get(factor);
                    list.add(l[i]);
                    map.replace(factor, list);
                }else {
                    List<Integer>integerList=new ArrayList<>();
                    integerList.add(l[i]);
                    map.put(factor, integerList);
                }
            }
        }
        StringBuilder res= new StringBuilder();
        for (var key:map.keySet()){
            var list=map.get(key);
            int sum=0;
            for (var num:list){
                sum+=num;
            }
            res.append("(").append(key).append(" ").append(sum).append(")");
        }
        return res.toString();
    }

    private static List<Integer> getPrimeFactors(int num) {
        int n = (int)Math.sqrt(num);
        List<Integer>primes=new ArrayList<>();
        for(int i=2; i<=n; i++){
            if(num%i==0){
                while (num%i==0){
                    num=num/i;
                }
                primes.add(i);
            }
        }
        if(num!=1){
            primes.add(num);
        }
            return primes;
    }


}
