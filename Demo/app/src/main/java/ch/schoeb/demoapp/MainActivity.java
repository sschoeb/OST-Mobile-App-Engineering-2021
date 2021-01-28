package ch.schoeb.demoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lifecycleButton = (Button) findViewById(R.id.buttonLifecycle);
        lifecycleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LifecycleActivity.class));
            }
        });

        Button layoutParameterButton = (Button) findViewById(R.id.buttonLayoutParameter);
        layoutParameterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LayoutParametersActivity.class));
            }
        });

        Button anrButton = (Button)findViewById(R.id.buttonAnr);
        anrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Thread.sleep(300000);
                } catch (InterruptedException e) {

                }
            }
        });

        Button appBarButton = (Button)findViewById(R.id.buttonAppBar);
        appBarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AppBarDemo.class));
            }
        });
    }
}
