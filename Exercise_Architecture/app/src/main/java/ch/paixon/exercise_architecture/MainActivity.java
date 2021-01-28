package ch.paixon.exercise_architecture;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ch.paixon.exercise_architecture.dto.ConnectionContainerDto;
import ch.paixon.exercise_architecture.dto.ConnectionDto;
import ch.paixon.exercise_architecture.viewmodels.ConnectionViewModel;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.originTime)
    public TextView originTime;

    @BindView(R.id.destinationTime)
    public TextView destinationTime;

    private ConnectionViewModel connectionsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        this.connectionsViewModel = ViewModelProviders.of(this).get(ConnectionViewModel.class);

        this.connectionsViewModel.getConnections().observe(this, new Observer<ConnectionContainerDto>() {
            @Override
            public void onChanged(@Nullable ConnectionContainerDto connectionsContainer) {
                ConnectionDto connection = connectionsContainer.connections.get(0);
                originTime.setText(connection.from.departure.toString());
                destinationTime.setText(connection.to.arrival.toString());
            }
        });
    }
}