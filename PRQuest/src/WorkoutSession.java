import java.time.LocalDate;
import java.util.ArrayList;

public class WorkoutSession {
    private LocalDate date;
    private long startTimeMillis;
    private ArrayList<Exercise> exercises;

    public WorkoutSession() {
        this.date = LocalDate.now();
        this.startTimeMillis = System.currentTimeMillis();
        this.exercises = new ArrayList<Exercise>();
    }

    public void addExercise(String name) {
        // Guard against blank names even if a command forgets to check first.
        if (name == null || name.trim().isEmpty()) {
            return;
        }
        exercises.add(new Exercise(name.trim(), "General"));
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    // Helper for LOG SET: the exercise most recently added is the "active" one.
    public Exercise getCurrentExercise() {
        if (exercises.isEmpty()) {
            return null;
        }
        return exercises.get(exercises.size() - 1);
    }

    public LocalDate getDate() {
        return date;
    }

    public long getStartTimeMillis() {
        return startTimeMillis;
    }
}
