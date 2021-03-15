package ch.paixon.exercise_network_solution;


import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.paixon.exercise_network_solution.dtos.ConnectionContainerDto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://transport.opendata.ch/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ConnectionService service = retrofit.create(ConnectionService.class);

        service.searchConnections("Zürich", "Bern").enqueue(new Callback<ConnectionContainerDto>() {
            @Override
            public void onResponse(Call<ConnectionContainerDto> call, Response<ConnectionContainerDto> response) {
                if (response.isSuccessful()) {
                    ConnectionContainerDto connectionsContainer = response.body();
                    // Handle result...
                    originTime.setText(connectionsContainer.connections.get(0).from.departure.toString());
                    destinationTime.setText(connectionsContainer.connections.get(0).to.arrival.toString());
                }
            }

            @Override
            public void onFailure(Call<ConnectionContainerDto> call, Throwable t) {
                Log.d("Test", "fail");
            }
        });
    }
}
