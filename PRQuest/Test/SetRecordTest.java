import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SetRecordTest {

    @Test
    public void testGetWeightNormal() {
        SetRecord set = new SetRecord(225, 8);
        assertEquals(225.0, set.getWeight());
    }

    @Test
    public void testGetWeightEdgeZero() {
        SetRecord set = new SetRecord(0, 5);
        assertEquals(0.0, set.getWeight());
    }

    @Test
    public void testGetRepsNormal() {
        SetRecord set = new SetRecord(135, 8);
        assertEquals(8, set.getReps());
    }

    @Test
    public void testGetRepsEdgeZero() {
        SetRecord set = new SetRecord(135, 0);
        assertEquals(0, set.getReps());
    }
}
