import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SummaryCommandTest {

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
    public void testExecuteNormalWithData() {
        User user = new User();
        user.startSession();
        user.getActiveSession().addExercise("Squat");
        user.getActiveSession().getCurrentExercise().addSet(225, 5);

        new SummaryCommand().execute(user);

        String output = outContent.toString();
        assertTrue(output.contains("Squat"));
        assertTrue(output.contains("225.0"));
    }

    @Test
    public void testExecuteBadInputNoActiveSession() {
        User user = new User();
        new SummaryCommand().execute(user);
        assertTrue(outContent.toString().contains("No active workout session."));
    }
}
