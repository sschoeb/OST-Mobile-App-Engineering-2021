package ch.paixon.exercise_architecture;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import ch.paixon.exercise_architecture.dto.ConnectionContainerDto;
import ch.paixon.exercise_architecture.viewmodels.ConnectionViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectionWebService {

    private ConnectionService service;

    public ConnectionWebService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://transport.opendata.ch/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.service = retrofit.create(ConnectionService.class);
    }

    public LiveData<ConnectionContainerDto> searchConnection(String from, String to) {
        final MutableLiveData<ConnectionContainerDto> data = new MutableLiveData<>();
        Call<ConnectionContainerDto> call = this.service.searchConnections(from, to);

        call.enqueue(new Callback<ConnectionContainerDto>() {
            @Override
            public void onResponse(Call<ConnectionContainerDto> call, Response<ConnectionContainerDto> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<ConnectionContainerDto> call, Throwable t) {

            }
        });

        return data;
    }

}
