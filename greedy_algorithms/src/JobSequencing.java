import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class JobSequencing {
    //Given jobs with profit and deadline find max profit can be earned
    private static class Job{
        private String  name;
        private int profit;
        private int deadline;

        public Job(String name, int profit, int deadline) {
            this.name = name;
            this.profit = profit;
            this.deadline = deadline;
        }
    }
    public static int findMaxProfit(List<Job>jobs, int maxSlots){
        Comparator<Job>profitComparator=new Comparator<Job>() {  // sorting in decreasing order of profit
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit- o1.profit;
            }
        };
        Collections.sort(jobs, profitComparator);
        int []slots=new int[maxSlots];  // Initially each  slot is filled with 0 . Once occupied it will be replaced with 1
        int maxProfit=0;
        var job1=jobs.get(0);
        maxProfit+=job1.profit;
        slots[job1.deadline-1]=1;   // Job with deadline 4 will be stored at  index 3 in slots
        for (int i=1;i<jobs.size();i++){
            var job =jobs.get(i);
            boolean flag=false;
            for (int j=job.deadline-1;j>=0;j--){
                if (slots[j]==0) {
                    slots[j] = 1;
                    maxProfit+=job.profit;
                    flag=true;
                }
                if (flag)
                    break;
            }
        }return maxProfit;
    }

    public static void main(String[] args) {
        List<Job>jobs=new ArrayList<>();
        jobs.add(new Job("J1", 35, 3));
        jobs.add(new Job("J2", 30, 4));
        jobs.add(new Job("J3", 25, 4));
        jobs.add(new Job("J4", 20, 2));
        jobs.add(new Job("J5", 15, 3));
        jobs.add(new Job("J6", 12, 1));
        jobs.add(new Job("J7", 5, 2));

        int maxProfit=findMaxProfit(jobs, 4);
        System.out.println(maxProfit);
    }

}
