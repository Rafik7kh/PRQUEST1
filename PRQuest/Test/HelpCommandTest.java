import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelpCommandTest {

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
    public void testExecuteNormal() {
        new HelpCommand().execute();
        assertTrue(outContent.toString().contains("Available commands"));
    }

    @Test
    public void testExecuteEdgeCalledMultipleTimes() {
        new HelpCommand().execute();
        new HelpCommand().execute();
        // Calling it twice shouldn't throw or change behavior.
        assertTrue(outContent.toString().contains("HELP"));
    }
}
