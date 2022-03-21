import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public void removeDuplicates(int[] array){
        Set<Integer>set=new HashSet<>();

        for(var num : array)
            set.add(num);

        System.out.println(set);
    }

    public static void main(String[] args) {
        int [] arr={2,4,6,2,3,4,5,3,4,5,2,8};
        RemoveDuplicates removeDuplicates=new RemoveDuplicates();
        removeDuplicates.removeDuplicates(arr);
    }
}
