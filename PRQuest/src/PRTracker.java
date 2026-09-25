import java.util.HashMap;

public class PRTracker {
    private HashMap<String, HashMap<Integer, Double>> personalRecords;

    public PRTracker() {
        this.personalRecords = new HashMap<String, HashMap<Integer, Double>>();
    }

    public String checkPR(String exerciseName) {
        HashMap<Integer, Double> records = personalRecords.get(exerciseName);
        if (records == null || records.isEmpty()) {
            return "No personal records found for " + exerciseName + ".";
        }
        StringBuilder result = new StringBuilder("Personal records for " + exerciseName + ":\n");
        for (Integer reps : records.keySet()) {
            result.append("  " + reps + " reps: " + records.get(reps) + "\n");
        }
        return result.toString().trim();
    }

    public void updateRecords(WorkoutSession session) {
        for (Exercise exercise : session.getExercises()) {
            String name = exercise.getName();
            HashMap<Integer, Double> records = personalRecords.get(name);
            if (records == null) {
                records = new HashMap<Integer, Double>();
                personalRecords.put(name, records);
            }
            for (SetRecord set : exercise.getSets()) {
                Double currentBest = records.get(set.getReps());
                if (currentBest == null || set.getWeight() > currentBest) {
                    records.put(set.getReps(), set.getWeight());
                    System.out.println("New PR! " + name + " - " + set.getWeight() + " for " + set.getReps() + " reps.");
                }
            }
        }
    }
}
