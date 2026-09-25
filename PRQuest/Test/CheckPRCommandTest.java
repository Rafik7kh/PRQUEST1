import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CheckPRCommandTest {

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
    public void testExecuteNormalValidExercise() {
        PRTracker tracker = new PRTracker();
        new CheckPRCommand().execute(tracker, "Squat");
        assertTrue(outContent.toString().contains("No personal records found for Squat."));
    }

    @Test
    public void testExecuteBadInputBlankName() {
        PRTracker tracker = new PRTracker();
        new CheckPRCommand().execute(tracker, "   ");
        assertTrue(outContent.toString().contains("Please specify an exercise name."));
    }
}
