package ch.schoeb.demoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class LifecycleActivity extends AppCompatActivity {

    private final String Tag = "ActivityLifecycleTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        Log.d(Tag, "onCreate");

        Button finishButton = (Button)findViewById(R.id.buttonFinishLifecycle);
        finishButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Tag, "----onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Tag, "----onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Tag, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(Tag, "--onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Tag, "--onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Tag, "--onStop");
    }
}
