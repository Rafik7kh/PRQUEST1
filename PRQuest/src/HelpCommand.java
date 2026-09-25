public class HelpCommand {
    public void execute() {
        System.out.println("Available commands:");
        System.out.println("  START WORKOUT             - begin a new workout session");
        System.out.println("  ADD EXERCISE <name>       - add an exercise to the session");
        System.out.println("  LOG SET <weight> <reps>   - log a set for the current exercise");
        System.out.println("  CHECK PR <exercise>       - show the personal best for an exercise");
        System.out.println("  SUMMARY                   - show exercises and sets logged so far");
        System.out.println("  FINISH WORKOUT            - end and save the session");
        System.out.println("  HELP                      - show this list");
        System.out.println("  QUIT                      - exit the program");
    }
}
