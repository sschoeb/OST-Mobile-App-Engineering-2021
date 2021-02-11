package ch.paixon.exercise_asynctask_solution;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textViewState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textViewState = (TextView) findViewById(R.id.textViewState);

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new Worker().execute();
            }
        });
    }

    class Worker extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressBar.setProgress(0);
            textViewState.setText("Started");
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            textViewState.setText("Finished");
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            int progress = 0;
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                progress += 10;
                publishProgress(progress);
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0]);
        }
    }
}
