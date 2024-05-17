// "static void main" must be defined in a public class.
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SurveillanceData surveillanceData = generateSurveillanceData();
        List<Long> footage = surveillanceData.getFootage();
        long robberAppearance = surveillanceData.getRobberAppearance();

        int robberIndex = findRobber(footage, robberAppearance);
        System.out.println("Robber appeared at index: " + robberIndex);
    }

    /**
     * Generates an array of 1000 timestamps within a weeklong period at regular intervals,
     * and randomly selects one timestamp to represent the robber's appearance.
     *
     * @return An object containing two keys:
     *         - footage: An array of 1000 timestamps.
     *         - robberAppearance: The timestamp of the robber's appearance.
     */
    public static SurveillanceData generateSurveillanceData() {
        List<Long> footage = new ArrayList<>();
        Date startDate = new Date(2024 - 1900, 4, 7); // Start date for the surveillance footage
        Date endDate = new Date(2024 - 1900, 4, 14); // End date for the surveillance footage
        long interval = (endDate.getTime() - startDate.getTime()) / 1000 / 1000; // Interval in seconds between timestamps

        // Generate 1000 timestamps at regular intervals throughout the week
        for (int i = 0; i < 1000; i++) {
            long timestamp = startDate.getTime() + i * interval;
            footage.add(timestamp);
        }

        // Randomly select one timestamp as the robber's appearance
        Random random = new Random();
        int robberIndex = random.nextInt(1000);
        long robberAppearance = footage.get(robberIndex);

        return new SurveillanceData(footage, robberAppearance);
    }

    /**
     * Finds the index of the robber's appearance in the array of recorded timestamps.
     *
     * @param footage          An array of recorded timestamps.
     * @param robberAppearance The timestamp of the robber's appearance.
     * @return The index of the robber's appearance in the array.
     */
    
    /**
    Binary search for O(log(n))
    */
    
    // time: O(log(n)), space: O(1)
    public static int findRobber(List<Long> footage, long robberAppearance) {
        int i = footage.size() / 2;
        Boolean found = false;
        int start = 0;
        int end = footage.size() - 1;
        
        while(!found){
            if(footage.get(i) == robberAppearance){
                return i;
            }
            else if(robberAppearance > footage.get(i)){
                start = i;
                i = (end + start) / 2;
            }
            else{
                end = i;
                i = (end + start) / 2;
            }
        }
        
        return 0;
    }
}

class SurveillanceData {
    private List<Long> footage;
    private long robberAppearance;

    public SurveillanceData(List<Long> footage, long robberAppearance) {
        this.footage = footage;
        this.robberAppearance = robberAppearance;
    }

    public List<Long> getFootage() {
        return footage;
    }

    public long getRobberAppearance() {
        return robberAppearance;
    }
}