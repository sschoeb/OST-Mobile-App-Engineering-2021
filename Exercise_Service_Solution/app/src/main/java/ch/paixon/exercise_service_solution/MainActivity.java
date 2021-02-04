package ch.paixon.exercise_service_solution;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView _currentCounterValueTextView;
    private CounterService _counterService;

    private ServiceConnection _serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            _counterService = ((CounterService.CounterServiceBinder) binder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onResume() {
        super.onResume();

        // Bind to existing Counter Service
        Intent serviceIntent = new Intent(this, CounterService.class);
        bindService(serviceIntent, _serviceConnection, 0);
    }

    @Override
    protected void onPause() {
        super.onPause();

        unbindService(_serviceConnection);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _currentCounterValueTextView = (TextView) findViewById(R.id.textViewCurrentCounter);

        Button increaseButton = (Button) findViewById(R.id.buttonIncrease);
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseCounterOnService();
            }
        });

        Button readButton = (Button) findViewById(R.id.buttonReadCounter);
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readCounterValue();
            }
        });

        // Create a new Service instance
        Intent serviceIntent = new Intent(this, CounterService.class);
        startService(serviceIntent);
    }

    private void increaseCounterOnService() {
        _counterService.increaseCounter();
    }

    private void readCounterValue() {
        int currentServiceCounter = _counterService.getCounter();
        _currentCounterValueTextView.setText(currentServiceCounter + "");
    }
}
