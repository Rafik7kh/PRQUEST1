import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PRTrackerTest {

    @Test
    public void testCheckPRNoRecords() {
        PRTracker tracker = new PRTracker();
        String result = tracker.checkPR("Squat");
        assertEquals("No personal records found for Squat.", result);
    }

    @Test
    public void testCheckPRWithRecords() {
        PRTracker tracker = new PRTracker();
        WorkoutSession session = new WorkoutSession();
        session.addExercise("Squat");
        session.getCurrentExercise().addSet(225, 5);
        tracker.updateRecords(session);

        String result = tracker.checkPR("Squat");
        assertTrue(result.contains("Squat"));
        assertTrue(result.contains("225.0"));
    }

    @Test
    public void testUpdateRecordsNormalNewPR() {
        PRTracker tracker = new PRTracker();
        WorkoutSession session = new WorkoutSession();
        session.addExercise("Bench Press");
        session.getCurrentExercise().addSet(135, 5);
        tracker.updateRecords(session);

        // Log a heavier set at the same rep count in a second session.
        WorkoutSession session2 = new WorkoutSession();
        session2.addExercise("Bench Press");
        session2.getCurrentExercise().addSet(155, 5);
        tracker.updateRecords(session2);

        assertTrue(tracker.checkPR("Bench Press").contains("155.0"));
    }

    @Test
    public void testUpdateRecordsBadInputNoExercises() {
        PRTracker tracker = new PRTracker();
        WorkoutSession session = new WorkoutSession();
        tracker.updateRecords(session);
        assertEquals("No personal records found for Squat.", tracker.checkPR("Squat"));
    }
}
