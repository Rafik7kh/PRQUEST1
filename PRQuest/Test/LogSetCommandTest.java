import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LogSetCommandTest {

    @Test
    public void testExecuteNormal() {
        User user = new User();
        user.startSession();
        user.getActiveSession().addExercise("Bench Press");

        new LogSetCommand().execute(user, 135, 5);

        Exercise exercise = user.getActiveSession().getCurrentExercise();
        assertEquals(1, exercise.getSets().size());
    }

    @Test
    public void testExecuteBadInputNoActiveExercise() {
        User user = new User();
        user.startSession();

        new LogSetCommand().execute(user, 135, 5);

        assertTrue(user.getActiveSession().getExercises().isEmpty());
    }

    @Test
    public void testExecuteBadInputNegativeValues() {
        User user = new User();
        user.startSession();
        user.getActiveSession().addExercise("Bench Press");

        new LogSetCommand().execute(user, -50, 5);

        assertTrue(user.getActiveSession().getCurrentExercise().getSets().isEmpty());
    }

    @Test
    public void testExecuteBadInputExceedsBounds() {
        User user = new User();
        user.startSession();
        user.getActiveSession().addExercise("Bench Press");

        new LogSetCommand().execute(user, 9999, 5);

        assertTrue(user.getActiveSession().getCurrentExercise().getSets().isEmpty());
    }
}
