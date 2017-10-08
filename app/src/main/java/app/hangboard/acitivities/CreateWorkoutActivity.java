package app.hangboard.acitivities;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import app.hangboard.R;
import app.hangboard.dialog.CreateExerciseDialog;
import app.hangboard.workout.Hang;
import app.hangboard.workout.Workout;

/**
 * Creates a new workout
 */
public class CreateWorkoutActivity extends FragmentActivity
        implements CreateExerciseDialog.CreateExerciseDialogListener{


    private Workout workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);
        workout = new Workout();
    }

    /**
     * Create workouts
     * @param view View
     */
    public void createWorkout(View view) {


//        Intent intent = new Intent(this, ConfirmWorkoutActivity.class);
//
//        EditText repsText = (EditText) findViewById(R.id.reps);
//        String reps = repsText.getText().toString();
//
//        EditText durationText = (EditText) findViewById(R.id.duration);
//        String duration = durationText.getText().toString();
//
//        EditText restText = (EditText) findViewById(R.id.rest);
//        String rest = restText.getText().toString();
//
//        Hang hang = new Hang();
//        hang.setLength(Double.parseDouble(duration));
//        hang.setRest(Double.parseDouble(rest));
//        hang.setRepetitions(Integer.parseInt(reps));
//
//
//        startActivity(intent);

        DialogFragment dialog = new CreateExerciseDialog();
        dialog.show(getSupportFragmentManager(), "CreateExerciseDialog");
    }

    public void onDialogPositiveClick(DialogFragment dialog) {

        // Save exercise to the list
        Hang hang = new Hang();
        workout.addHang(hang);


    }

    public void createNewExercise() {
        DialogFragment newFragment = new CreateExerciseDialog();
        newFragment.show(getSupportFragmentManager(), "exercise");
    }
}
