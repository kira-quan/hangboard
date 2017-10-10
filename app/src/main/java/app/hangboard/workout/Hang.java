package app.hangboard.workout;

/**
 * A single hang set in a hangboard workout
 * Created by kira on 9/30/17.
 */

public class Hang {

    private Integer repetitions;
    private Integer length;
    private Integer sequence;
    private Integer rest;

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getRest() {
        return rest;
    }

    public void setRest(Integer rest) {
        this.rest = rest;
    }

    @Override
    public String toString() {
        return "Hang{" +
                "repetitions=" + repetitions +
                ", length=" + length +
                ", sequence=" + sequence +
                ", rest=" + rest +
                '}';
    }
}
