package ch.paixon.exercise_testing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    long counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = (Button)findViewById(R.id.buttonAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(1);
            }
        });

        final Button subtractButton = (Button)findViewById(R.id.buttonSubtract);
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtract(1);
            }
        });

        final Button addValueButton = (Button)findViewById(R.id.buttonAddValue);
        addValueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText valueEditText = (EditText)findViewById(R.id.valueEditText);
                add(Integer.parseInt(valueEditText.getText().toString()));
            }
        });
    }

    private void subtract(int count){
        counter -= count;
        updateCounterOnView();
    }

    private void add(int count){
        counter += count;
        updateCounterOnView();
    }

    private void updateCounterOnView(){
        TextView counterTextView = (TextView)findViewById(R.id.counterValue);
        counterTextView.setText(counter + "");
    }
}
