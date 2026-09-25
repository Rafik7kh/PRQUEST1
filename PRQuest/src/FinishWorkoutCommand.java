public class FinishWorkoutCommand {
    public void execute(User user, PRTracker tracker) {
        if (user.getActiveSession() == null) {
            System.out.println("No active workout to finish.");
            return;
        }
        WorkoutSession session = user.getActiveSession();
        tracker.updateRecords(session);
        user.finishSession();
        System.out.println("Workout finished and saved. Great job!");
    }
}
