import java.util.*;
public class DiscStacking {
    //Given an array which contains another array as dimensions of disk , stack up the disc on top of each other
    //form the tallest tower possible, Caveat: width , depth and height of above disk has to be strictly lesser than that of below disc
    //TC:O(n^2) || SC:O(n)
    public static List<Integer[]>diskStacking(List<Integer[]> disks){
        disks.sort(Comparator.comparing(disk -> disk[2]));
        int[]heights=new int[disks.size()];
        for (int i=0;i<disks.size();i++)
            heights[i]=disks.get(i)[2];
        int []sequences=new int[disks.size()];    //Keeps track of disk that come on top of another one
        for (int i=0;i<disks.size();i++)
            sequences[i]=Integer.MIN_VALUE;
        int maxHeightIdx=0;
        for (int i=1;i<disks.size();i++){
            Integer[]currentDisk=disks.get(i);
            for (int j=0;j<i;j++){
                Integer[] otherDisk=disks.get(j);
                if (areValidDimensions(otherDisk, currentDisk)){
                    if (heights[i] <= currentDisk[2] + heights[j]) {
                        heights[i] = currentDisk[2] + heights[j];
                        sequences[i] = j;
                    }
                }
            }
            if (heights[i]>=heights[maxHeightIdx])
                maxHeightIdx=i;     //This will be index of max value in heights array after updating for current(ith) disk
        }
        return buildSequence(disks, sequences, maxHeightIdx);
    }
    private static List<Integer[]> buildSequence(List<Integer[]> array, int[] sequences, int currentIndex) {
        List<Integer[]>sequence=new ArrayList<>();  //This will store [bottomDisk, secondBottomDisk, .... topDisk]

        while (currentIndex!=Integer.MIN_VALUE){
            sequence.add(array.get(currentIndex));
            currentIndex=sequences[currentIndex];   //now current index will point to index of disc that will come on top of current disc
        }
        //Reverse the sequence
        List<Integer[]>reversedSequence=new ArrayList<>(); // This will store top disk first
        for (int i=sequence.size()-1;i>=0;i--){
            reversedSequence.add(sequence.get(i));
        }
        return reversedSequence;
    }
    private static boolean areValidDimensions(Integer[] od, Integer[] cd) {
        return od[0]<cd[0] && od[1]<cd[1] && od[2]<cd[2];
    }
    public static void main(String[] args) {
        Integer[][]disks={{2,2,1},{2,1,2},{3,2,3},{2,3,4},{4,4,5},{2,2,8}};
        var stackedDisk=diskStacking(Arrays.asList(disks));
        for (var disk:stackedDisk) {
            System.out.println(Arrays.toString(disk));
        }
    }
}
