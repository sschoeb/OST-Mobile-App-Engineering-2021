package ch.paixon.exercise_service;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView _currentCounterValueTextView;

    // TODO: Create a ServiceConnection to connect to the service
    // TODO: Use Activity-Lifecycle (onResume/onPause) methods to bind/unbind the service

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _currentCounterValueTextView = (TextView)findViewById(R.id.textViewCurrentCounter);

        Button increaseButton = (Button) findViewById(R.id.buttonIncrease);
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseCounterOnService();
            }
        });

        Button readButton = (Button)findViewById(R.id.buttonReadCounter);
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readCounterValue();
            }
        });
    }

    private void increaseCounterOnService() {
        // TODO: Tell the service to increase the counter
    }

    private void readCounterValue() {
        // TODO: Get the current counter value from the service
        // TODO: Write the current counter to the _currentCounterValueTextView
    }
}
