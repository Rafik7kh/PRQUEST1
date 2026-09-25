import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testStartSessionNormal() {
        User user = new User();
        user.startSession();
        assertNotNull(user.getActiveSession());
    }



    @Test
    public void testFinishSessionNormal() {
        User user = new User();
        user.startSession();
        user.getActiveSession().addExercise("Squat");
        user.finishSession();
        assertEquals(1, user.getHistory().size());
        assertNull(user.getActiveSession());
    }

    @Test
    public void testFinishSessionBadInputNoActiveSession() {
        User user = new User();
        user.finishSession();
        assertEquals(0, user.getHistory().size());
        assertNull(user.getActiveSession());
    }

    @Test
    public void testGetActiveSessionNormal() {
        User user = new User();
        user.startSession();
        assertNotNull(user.getActiveSession());
    }

    @Test
    public void testGetActiveSessionEdgeNoSession() {
        User user = new User();
        assertNull(user.getActiveSession());
    }
}
