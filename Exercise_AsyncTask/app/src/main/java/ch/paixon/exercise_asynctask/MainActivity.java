package ch.paixon.exercise_asynctask;

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

            // TODO:
            // - Stelle sicher, dass der Progress auf 0 steht
            // - Stelle sicher, dass "Started in der textViewState"
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // TODO:
            // - Stelle sicher, dass "Finished" in der "textViewState"
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            // TODO: Zähle den Stand von 0 auf 100
            // - Benutze Thread.sleep(1000) um alles sichtbar zu machen
            // - Zeige den aktuellen Stand dem Benutzer -> publishProgress(...)
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            // TODO: Stelle sicher, dass der aktuelle Stand (values[0]) in der
            // ProgressBar angezeigt wird

        }
    }
}
