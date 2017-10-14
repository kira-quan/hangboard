package app.hangboard.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import app.hangboard.R;

import static java.security.AccessController.getContext;

public class WorkoutActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String PROFILE_NAME = "profile_name";
    private static final String PROFILE_HEIGHT_FEET = "profile_height_feet";
    private static final String PROFILE_HEIGHT_INCHES = "profile_height_inches";
    private static final String PROFILE_WEIGHT = "profile_weight";
    private static final String PROFILE_AGE = "profile_age";

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_stats:
                    return true;
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_settings:
                    Intent intent = new Intent(WorkoutActivity.this, SettingsActivity.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        // Set up the navigation listener
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Set the profile name on the header
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        String profileName = sharedPreferences.getString(PROFILE_NAME, "Profile Name");
        Integer profileHeightFeet = sharedPreferences.getInt(PROFILE_HEIGHT_FEET, 5);
        Integer profileHeightInches = sharedPreferences.getInt(PROFILE_HEIGHT_INCHES, 5);
        Integer profileWeight = sharedPreferences.getInt(PROFILE_WEIGHT, 100);
        Integer profileAge = sharedPreferences.getInt(PROFILE_AGE, 30);

        TextView header = (TextView) findViewById(R.id.header);
        header.setText(profileName);
    }

    public void createWorkout(View view) {
        // Create a new workout
        Intent intent = new Intent(this, CreateWorkoutActivity.class);
        EditText editText = (EditText) findViewById(R.id.reps);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


}
