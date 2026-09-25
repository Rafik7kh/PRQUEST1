import java.util.ArrayList;

public class Exercise {
    private String name;
    private String muscleGroup;
    private ArrayList<SetRecord> sets;

    public Exercise(String name, String muscleGroup) {
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.sets = new ArrayList<SetRecord>();
    }

    public void addSet(double weight, int reps) {
        sets.add(new SetRecord(weight, reps));
    }

    public String getName() {
        return name;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public ArrayList<SetRecord> getSets() {
        return sets;
    }
}
