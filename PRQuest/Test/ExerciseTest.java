import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class ExerciseTest {

    @Test
    public void testAddSetNormal() {
        Exercise exercise = new Exercise("Bench Press", "Chest");
        exercise.addSet(135, 5);
        assertEquals(1, exercise.getSets().size());
        assertEquals(135.0, exercise.getSets().get(0).getWeight());
        assertEquals(5, exercise.getSets().get(0).getReps());
    }

   

    @Test
    public void testGetNameNormal() {
        Exercise exercise = new Exercise("Bench Press", "Chest");
        assertEquals("Bench Press", exercise.getName());
    }

    @Test
    public void testGetNameEdgeEmpty() {
        Exercise exercise = new Exercise("", "Chest");
        assertEquals("", exercise.getName());
    }

    @Test
    public void testGetSetsNormal() {
        Exercise exercise = new Exercise("Squat", "Legs");
        exercise.addSet(135, 5);
        exercise.addSet(155, 5);
        exercise.addSet(185, 3);
        assertEquals(3, exercise.getSets().size());
    }

    @Test
    public void testGetSetsEdgeEmpty() {
        Exercise exercise = new Exercise("Squat", "Legs");
        ArrayList<SetRecord> sets = exercise.getSets();
        assertTrue(sets.isEmpty());
    }
}
