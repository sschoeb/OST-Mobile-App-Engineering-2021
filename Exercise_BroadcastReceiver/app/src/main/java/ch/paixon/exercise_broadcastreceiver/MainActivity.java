package ch.paixon.exercise_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView powerIndicatorTextView;

    BroadcastReceiver powerSaverChangeReceiverLow = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateUI(intent.getData().toString());
        }
    };


    public void updateUI(String level) {
        powerIndicatorTextView.setText(level);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.powerIndicatorTextView = findViewById(R.id.powerIndicator);

        IntentFilter filter = new IntentFilter();
        filter.addAction("CHANGE_NETWORK_STATE");
        registerReceiver(powerSaverChangeReceiverLow, filter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(powerSaverChangeReceiverLow);
    }
}
