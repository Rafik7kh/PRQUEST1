import java.util.Scanner;

public class WorkoutApp {
    private User user;
    private PRTracker tracker;
    private boolean running;

    public WorkoutApp() {
        this.user = new User();
        this.tracker = new PRTracker();
        this.running = false;
    }

    public void startApp() {
        Scanner scanner = new Scanner(System.in);
        running = true;
        System.out.println("Welcome to PR Quest!");
        new HelpCommand().execute();

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine();
            processCommand(input);
        }

        scanner.close();
        System.out.println("Goodbye!");
    }

    public void processCommand(String command) {
        if (command == null) {
            return;
        }
        String trimmed = command.trim();
        String upper = trimmed.toUpperCase();

        if (upper.equals("HELP")) {
            new HelpCommand().execute();

        } else if (upper.equals("START WORKOUT")) {
            new StartWorkoutCommand().execute(user);

        } else if (upper.equals("FINISH WORKOUT")) {
            new FinishWorkoutCommand().execute(user, tracker);

        } else if (upper.equals("SUMMARY")) {
            new SummaryCommand().execute(user);

        } else if (upper.equals("QUIT") || upper.equals("EXIT")) {
            running = false;

        } else if (upper.startsWith("ADD EXERCISE")) {
            String name = trimmed.length() > 12 ? trimmed.substring(12).trim() : "";
            new AddExerciseCommand().execute(user, name);

        } else if (upper.startsWith("CHECK PR")) {
            String name = trimmed.length() > 8 ? trimmed.substring(8).trim() : "";
            new CheckPRCommand().execute(tracker, name);

        } else if (upper.startsWith("LOG SET")) {
            String rest = trimmed.length() > 7 ? trimmed.substring(7).trim() : "";
            String[] parts = rest.isEmpty() ? new String[0] : rest.split("\\s+");
            if (parts.length < 2) {
                System.out.println("Usage: LOG SET <weight> <reps>");
                return;
            }
            try {
                double weight = Double.parseDouble(parts[0]);
                int reps = Integer.parseInt(parts[1]);
                new LogSetCommand().execute(user, weight, reps);
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numeric digits only.");
            }

        } else {
            System.out.println("Unrecognized command. Type HELP to see available commands.");
        }
    }
}
