package app.hangboard.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import app.hangboard.R;
import app.hangboard.workout.Hang;

/**
 * Created by kira on 10/9/17.
 */

public class ExerciseRowAdapter<T> extends ArrayAdapter<T> {

    public ExerciseRowAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ExerciseRowAdapter(Context context, int resource, List<T> items) {
        super(context, resource, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.exercise_row, null);
        }

        Hang hang = (Hang) getItem(position);

        if (hang != null) {
            TextView reps =  v.findViewById(R.id.reps);
            TextView duration =  v.findViewById(R.id.duration);
            TextView rest = v.findViewById(R.id.rest);
            TextView exerciseNumber = v.findViewById(R.id.exercise_seq);

            if (reps != null) {
                reps.setText(hang.getRepetitions().toString());
            }

            if (duration != null) {
                duration.setText(String.format(":%02d", hang.getLength()));
            }

            if (rest != null) {
                rest.setText(String.format(":%02d", hang.getRest()));
            }

            exerciseNumber.setText("EX\n"+ (position + 1));
        }

        return v;
    }
}
