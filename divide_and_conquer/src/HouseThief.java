public class HouseThief {


    public int maxTheft(int[] HouseNetWorth) {
        return maxTheftRecursive(HouseNetWorth, 0);
    }

    private int maxTheftRecursive(int[] HouseNetWorth, int currentIndex) {
        if (currentIndex >= HouseNetWorth.length)
            return 0;

        int stealCurrentHouse = HouseNetWorth[currentIndex] + maxTheftRecursive(HouseNetWorth, currentIndex + 2);
        int skipCurrentHouse = maxTheftRecursive(HouseNetWorth, currentIndex + 1);

        return Math.max(stealCurrentHouse, skipCurrentHouse);
    }

    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] HouseNetWorth = {6, 7, 1, 30, 8, 2, 4};
        System.out.println(ht.maxTheft(HouseNetWorth));
        HouseNetWorth = new int[] {20, 5, 1, 13, 6, 11, 40};
        System.out.println(ht.maxTheft(HouseNetWorth));
    }
}
