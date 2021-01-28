package ch.paixon.exercise_network;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.originTime)
    public TextView originTime;

    @BindView(R.id.destinationTime)
    public TextView destinationTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.search)
    public void onSearchClick() {
        // TODO 1: Verwende Retrofit.Builder um eine Retrofit Instanz zu erstellen
        // TODO 2: Erstelle einen RetroFit Service sowie passende DTO-Klassen welcher das Connection-API representiert
        // TODO 3: Suche die nächsten Verbindungen von "Zürich" nach "Bern" und zeige die Zeiten der nächsten Verbindung im UI an
    }
}
