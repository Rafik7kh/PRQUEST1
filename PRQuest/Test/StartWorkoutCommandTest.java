import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StartWorkoutCommandTest {

    @Test
    public void testExecuteNormal() {
        User user = new User();
        new StartWorkoutCommand().execute(user);
        assertNotNull(user.getActiveSession());
    }

    @Test
    public void testExecuteBadInputAlreadyActive() {
        User user = new User();
        new StartWorkoutCommand().execute(user);
        WorkoutSession firstSession = user.getActiveSession();

        new StartWorkoutCommand().execute(user);
        assertSame(firstSession, user.getActiveSession());
    }
}
