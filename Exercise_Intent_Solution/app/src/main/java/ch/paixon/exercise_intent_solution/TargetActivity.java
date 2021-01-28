package ch.paixon.exercise_intent_solution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        String passedData = getIntent().getStringExtra("myextra");

        TextView textView =(TextView)findViewById(R.id.textViewValue);
        textView.setText(passedData);
    }
}
