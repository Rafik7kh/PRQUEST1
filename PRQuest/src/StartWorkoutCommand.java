public class StartWorkoutCommand {
    public void execute(User user) {
        if (user.getActiveSession() != null) {
            System.out.println("A workout is already in progress. Finish it before starting a new one.");
            return;
        }
        user.startSession();
        System.out.println("Workout started! Use ADD EXERCISE <name> to begin.");
    }
}
