import java.util.ArrayList;

public class User {
    private WorkoutSession activeSession;
    private ArrayList<WorkoutSession> history;
    private String weightUnit;

    public User() {
        this.activeSession = null;
        this.history = new ArrayList<WorkoutSession>();
        this.weightUnit = "lbs";
    }

    public void startSession() {
        activeSession = new WorkoutSession();
    }

    public void finishSession() {
        if (activeSession != null) {
            history.add(activeSession);
            activeSession = null;
        }
    }

    public WorkoutSession getActiveSession() {
        return activeSession;
    }

    public ArrayList<WorkoutSession> getHistory() {
        return history;
    }

    public String getWeightUnit() {
        return weightUnit;
    }
}
