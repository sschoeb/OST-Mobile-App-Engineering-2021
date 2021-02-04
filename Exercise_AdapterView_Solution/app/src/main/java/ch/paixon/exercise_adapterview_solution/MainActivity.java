package ch.paixon.exercise_adapterview_solution;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);

        PersonAdapter adapter = new PersonAdapter(this, PersonRepository.getPersons());
        listView.setAdapter(adapter);
    }
}
