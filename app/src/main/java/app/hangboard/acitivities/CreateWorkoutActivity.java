package app.hangboard.acitivities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import app.hangboard.R;
import app.hangboard.adapter.ExerciseRowAdapter;
import app.hangboard.dialog.CreateExerciseDialog;
import app.hangboard.workout.Hang;
import app.hangboard.workout.Workout;

/**
 * Creates a new workout
 */
public class CreateWorkoutActivity extends FragmentActivity
        implements CreateExerciseDialog.CreateExerciseDialogListener{


    private Workout workout;

    ArrayAdapter<Hang> adapter;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_stats);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_settings);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);
        workout = new Workout();

        // Set up the list
        ListView list = findViewById(R.id.listView);
        adapter=new ExerciseRowAdapter<Hang>(this, R.layout.exercise_row,
                workout.getHangs());

        list.setAdapter(adapter);

        // Set up navigation
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    /**
     * Create workouts
     * @param view View
     */
    public void createWorkout(View view) {


//        Intent intent = new Intent(this, ConfirmWorkoutActivity.class);
//        startActivity(intent);

        DialogFragment dialog = new CreateExerciseDialog();
        dialog.show(getSupportFragmentManager(), "CreateExerciseDialog");
    }

    public void onDialogPositiveClick(DialogFragment dialog) {


        EditText repsText = dialog.getDialog().findViewById(R.id.reps);
        String reps = repsText.getText().toString();

        EditText durationText = dialog.getDialog().findViewById(R.id.duration);
        String duration = durationText.getText().toString();

        EditText restText = dialog.getDialog().findViewById(R.id.rest);
        String rest = restText.getText().toString();

        Hang hang = new Hang();
        hang.setLength(Integer.parseInt(duration));
        hang.setRest(Integer.parseInt(rest));
        hang.setRepetitions(Integer.parseInt(reps));

        // Save exercise to the list
        workout.addHang(hang);

        adapter.notifyDataSetChanged();


    }

    public void createNewExercise() {
        DialogFragment newFragment = new CreateExerciseDialog();
        newFragment.show(getSupportFragmentManager(), "exercise");
    }
}
