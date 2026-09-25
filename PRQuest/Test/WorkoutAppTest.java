import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class WorkoutAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void redirectOutput() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreOutput() {
        System.setOut(originalOut);
    }

    @Test
    public void testProcessCommandNormalHelp() {
        WorkoutApp app = new WorkoutApp();
        app.processCommand("HELP");
        assertTrue(outContent.toString().contains("Available commands"));
    }

    @Test
    public void testProcessCommandBadInputUnrecognized() {
        WorkoutApp app = new WorkoutApp();
        app.processCommand("JUMP");
        assertTrue(outContent.toString().contains("Unrecognized command"));
    }

    @Test
    public void testProcessCommandNonNumericLogSet() {
        WorkoutApp app = new WorkoutApp();
        app.processCommand("START WORKOUT");
        app.processCommand("ADD EXERCISE Squat");
        app.processCommand("LOG SET abc 5");
        assertTrue(outContent.toString().contains("Please enter valid numeric digits only."));
    }

    @Test
    public void testProcessCommandFullFlow() {
        WorkoutApp app = new WorkoutApp();
        app.processCommand("START WORKOUT");
        app.processCommand("ADD EXERCISE Squat");
        app.processCommand("LOG SET 225 5");
        app.processCommand("SUMMARY");

        String output = outContent.toString();
        assertTrue(output.contains("Squat"));
        assertTrue(output.contains("225.0"));
    }
}
