public class AddExerciseCommand {
    public void execute(User user, String exerciseName) {
        if (user.getActiveSession() == null) {
            System.out.println("No active workout. Use START WORKOUT first.");
            return;
        }
        if (exerciseName == null || exerciseName.trim().isEmpty()) {
            System.out.println("Exercise name cannot be empty.");
            return;
        }
        user.getActiveSession().addExercise(exerciseName.trim());
        System.out.println("Added exercise: " + exerciseName.trim());
    }
}
