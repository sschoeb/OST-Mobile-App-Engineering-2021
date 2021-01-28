package ch.paixon.exercise_architecture;


import android.arch.lifecycle.LiveData;

import ch.paixon.exercise_architecture.dto.ConnectionContainerDto;

public class ConnectionRepository {

    private ConnectionWebService webService = new ConnectionWebService();

    public LiveData<ConnectionContainerDto> searchConnection(String from, String to) {
        return webService.searchConnection(from, to);
    }
}
