package ch.paixon.exercise_butterknife;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText firstNameInput;
    private EditText lastNameInput;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO Replace all findViewByIds and Click-Listener by Butterknife
        Button concatButton = findViewById(R.id.buttonConcat);
        this.firstNameInput = findViewById(R.id.inputFirstName);
        this.lastNameInput = findViewById(R.id.inputLastName);
        this.resultTextView = findViewById(R.id.textViewResult);

        concatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTextView.setText(firstNameInput.getText().toString() + ' ' + lastNameInput.getText().toString());
            }
        });
    }

}
