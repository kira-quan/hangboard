package app.hangboard.workout;

import java.util.ArrayList;
import java.util.List;

/**
 * A single hangboard workout
 * Created by kira on 9/30/17.
 */

public class Workout {

    private Double betweenRest;
    private Double longRest;
    private List<Hang> hangs;
    private String workoutName;

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public Double getBetweenRest() {
        return betweenRest;
    }

    public void setBetweenRest(Double betweenRest) {
        this.betweenRest = betweenRest;
    }

    public Double getLongRest() {
        return longRest;
    }

    public void setLongRest(Double longRest) {
        this.longRest = longRest;
    }

    public List<Hang> getHangs() {
        if (hangs == null)
            hangs = new ArrayList<>();
        return hangs;
    }

    public void setHangs(List<Hang> hangs) {
        this.hangs = hangs;
    }

    public void addHang(Hang hang) {
        if (hangs == null) {
            hangs = new ArrayList<>();
        }

        hangs.add(hang);
    }
}
