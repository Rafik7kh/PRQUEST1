import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AddExerciseCommandTest {

    @Test
    public void testExecuteNormal() {
        User user = new User();
        user.startSession();
        new AddExerciseCommand().execute(user, "Squat");
        assertEquals(1, user.getActiveSession().getExercises().size());
        assertEquals("Squat", user.getActiveSession().getExercises().get(0).getName());
    }

    @Test
    public void testExecuteBadInputNoActiveSession() {
        User user = new User();
        new AddExerciseCommand().execute(user, "Squat");
        assertNull(user.getActiveSession());
    }

    @Test
    public void testExecuteBadInputBlankName() {
        User user = new User();
        user.startSession();
        new AddExerciseCommand().execute(user, "   ");
        assertTrue(user.getActiveSession().getExercises().isEmpty());
    }
}
