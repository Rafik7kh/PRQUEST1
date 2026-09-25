public class SummaryCommand {
    public void execute(User user) {
        if (user.getActiveSession() == null) {
            System.out.println("No active workout session.");
            return;
        }
        WorkoutSession session = user.getActiveSession();
        if (session.getExercises().isEmpty()) {
            System.out.println("No exercises logged yet.");
            return;
        }
        System.out.println("Current workout summary:");
        for (Exercise exercise : session.getExercises()) {
            System.out.println("  " + exercise.getName() + ":");
            for (SetRecord set : exercise.getSets()) {
                System.out.println("    " + set.getWeight() + " x " + set.getReps());
            }
        }
    }
}
