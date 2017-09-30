package app.hangboard.workout;

/**
 * A single hang set in a hangboard workout
 * Created by kira on 9/30/17.
 */

public class Hang {

    private Integer repetitions;
    private Double length;
    private Integer sequence;
    private Double rest;

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Double getRest() {
        return rest;
    }

    public void setRest(Double rest) {
        this.rest = rest;
    }
}
