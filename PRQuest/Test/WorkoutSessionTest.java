import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WorkoutSessionTest {

    @Test
    public void testAddExerciseNormal() {
        WorkoutSession session = new WorkoutSession();
        session.addExercise("Squat");
        assertEquals(1, session.getExercises().size());
        assertEquals("Squat", session.getExercises().get(0).getName());
    }

    @Test
    public void testAddExerciseBadInputBlankName() {
        WorkoutSession session = new WorkoutSession();
        session.addExercise("   ");
        assertTrue(session.getExercises().isEmpty());
    }

    @Test
    public void testGetExercisesNormal() {
        WorkoutSession session = new WorkoutSession();
        session.addExercise("Squat");
        session.addExercise("Bench Press");
        session.addExercise("Deadlift");
        assertEquals(3, session.getExercises().size());
    }

    @Test
    public void testGetExercisesEdgeEmpty() {
        WorkoutSession session = new WorkoutSession();
        assertTrue(session.getExercises().isEmpty());
    }

    @Test
    public void testGetCurrentExerciseReturnsMostRecent() {
        WorkoutSession session = new WorkoutSession();
        session.addExercise("Squat");
        session.addExercise("Bench Press");
        assertEquals("Bench Press", session.getCurrentExercise().getName());
    }

    @Test
    public void testGetCurrentExerciseEdgeEmpty() {
        WorkoutSession session = new WorkoutSession();
        assertNull(session.getCurrentExercise());
    }
}
