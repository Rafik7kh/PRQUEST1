import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FinishWorkoutCommandTest {

    @Test
    public void testExecuteNormal() {
        User user = new User();
        PRTracker tracker = new PRTracker();
        user.startSession();
        user.getActiveSession().addExercise("Squat");
        user.getActiveSession().getCurrentExercise().addSet(225, 5);

        new FinishWorkoutCommand().execute(user, tracker);

        assertNull(user.getActiveSession());
        assertEquals(1, user.getHistory().size());
        assertTrue(tracker.checkPR("Squat").contains("225.0"));
    }

    @Test
    public void testExecuteBadInputNoActiveSession() {
        User user = new User();
        PRTracker tracker = new PRTracker();

        new FinishWorkoutCommand().execute(user, tracker);

        assertEquals(0, user.getHistory().size());
        assertNull(user.getActiveSession());
    }
}
