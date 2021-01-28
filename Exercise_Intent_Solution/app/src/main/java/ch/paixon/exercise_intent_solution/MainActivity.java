package ch.paixon.exercise_intent_solution;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.buttonNavigate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.editTextValue);
                String valueToPass = editText.getText().toString();

                Intent intent = new Intent(MainActivity.this, TargetActivity.class);
                intent.putExtra("myextra", valueToPass);
                startActivity(intent);
            }
        });
    }
}
