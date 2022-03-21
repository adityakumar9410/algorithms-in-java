import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class FractionalKnapsack {
    private static class Item{
        private int index;
        private int value;
        private int weight;
        private double ratio;

        public Item(int index, int value, int weight) {
            this.index = index;
            this.value = value;
            this.weight = weight;
            ratio=(value*1.0)/weight;
        }
    }

    public static void fractionalKnapsack(List<Item>items, int capacity){
        Comparator<Item>densityComparator= (o1, o2) -> {
            if (o2.ratio>o1.ratio)
                return 1;
            else
                return -1;
        };
        Collections.sort(items, densityComparator);
        int usedCapacity=0;
        double totalValue=0;
        for (var item:items){
            if (usedCapacity+item.weight<=capacity){   // If possible consume  all weight with max  density
                usedCapacity+=item.weight;
                System.out.println("Taken : "+item.index);
                totalValue+=item.value;
            }else {
                //else consume fractionally
                int remainingWeight=capacity-usedCapacity;
                double value=item.ratio*remainingWeight;
                System.out.println("Taken: "+"item index = " + item.index + ",obtained value = " + value +
                        ",used weight = " +remainingWeight+ ", ratio = " + item.index
                        + "]");
                usedCapacity+=remainingWeight;
                totalValue+=value;
            }
            if (usedCapacity==capacity)
                break;
        }
        //print finally obtained value
        System.out.println("\nTotal value obtained: "+ totalValue);
    }

    public static void main(String[] args) {
        List<Item>items=new ArrayList<>();
        int [] value = {6,2,1,8,3,5};
        int [] weight = {6,10,3,5,1,3};
        int capacity =10;
        //Add the user input data in Knapsack
        for(int i = 0; i<value.length;i++) {
            items.add(new Item(i+1, value[i], weight[i]));
        }

        fractionalKnapsack(items,capacity);
    }
}
