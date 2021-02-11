package ch.paixon.exercise_butterknife_solution;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
    @BindView(R.id.inputFirstName) EditText firstNameInput;
    @BindView(R.id.inputLastName) EditText lastNameInput;
    @BindView(R.id.textViewResult) TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonConcat)
    public void onConcatClick() {
        resultTextView.setText(firstNameInput.getText().toString() + ' ' + lastNameInput.getText().toString());
    }
}
