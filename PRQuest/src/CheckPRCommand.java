public class CheckPRCommand {
    public void execute(PRTracker tracker, String exerciseName) {
        if (exerciseName == null || exerciseName.trim().isEmpty()) {
            System.out.println("Please specify an exercise name.");
            return;
        }
        System.out.println(tracker.checkPR(exerciseName.trim()));
    }
}
