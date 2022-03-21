import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class ActivitySelection {
    private static class Activity {
        private String name;
        private int startTime;
        private int finishTime;

        public Activity(String name, int startTime, int finishTime) {
            this.name = name;
            this.startTime = startTime;
            this.finishTime = finishTime;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    //TC:O(nlog(n))   || SC:O(logN)  Quick sort time and space complexity
    public void activitySelection(List<Activity> activityList) {
        Comparator<Activity> finishTimeComparator = new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.finishTime - o2.finishTime;
            }
        };

        Collections.sort(activityList, finishTimeComparator);
        var previousActivity = activityList.get(0);

        System.out.println("\n\nRecommended Schedule : \n" + activityList.get(0));

        for (int i = 1; i < activityList.size(); i++) {
            var activity = activityList.get(i);
            if (activity.startTime >= previousActivity.finishTime) {
                System.out.println(activity);
                previousActivity = activity;
            }
        }
    }

    public static void main(String[] args) {

        ActivitySelection selection = new ActivitySelection();

        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("A1", 0, 6));
        activities.add(new Activity("A2", 3, 4));
        activities.add(new Activity("A3", 1, 2));
        activities.add(new Activity("A4", 5, 8));
        activities.add(new Activity("A5", 5, 7));
        activities.add(new Activity("A6", 8, 9));

        //Print user entered data
        System.out.println("User provided Schedule:");
        for (int i = 0; i < activities.size(); i++) {
            var activity = activities.get(i);
            System.out.println(activity);
        }

        selection.activitySelection(activities);
    }
}
