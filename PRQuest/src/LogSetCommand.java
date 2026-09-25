public class LogSetCommand {
    private static final double MAX_WEIGHT = 1500.0;
    private static final int MAX_REPS = 100;

    public void execute(User user, double weight, int reps) {
        if (user.getActiveSession() == null) {
            System.out.println("No active workout. Use START WORKOUT first.");
            return;
        }
        Exercise current = user.getActiveSession().getCurrentExercise();
        if (current == null) {
            System.out.println("No exercise selected. Use ADD EXERCISE first.");
            return;
        }
        if (weight <= 0 || reps <= 0) {
            System.out.println("Weight and repetitions must be positive numbers.");
            return;
        }
        if (weight > MAX_WEIGHT || reps > MAX_REPS) {
            System.out.println("Input exceeds realistic bounds.");
            return;
        }
        current.addSet(weight, reps);
        System.out.println("Logged " + weight + " x " + reps + " for " + current.getName());
    }
}
