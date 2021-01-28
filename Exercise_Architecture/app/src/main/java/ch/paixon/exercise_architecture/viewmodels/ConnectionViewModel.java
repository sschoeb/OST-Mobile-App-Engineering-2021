package ch.paixon.exercise_architecture.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import ch.paixon.exercise_architecture.ConnectionRepository;
import ch.paixon.exercise_architecture.dto.ConnectionContainerDto;


public class ConnectionViewModel extends ViewModel {

    private ConnectionRepository connectionRepository = new ConnectionRepository();

    private LiveData<ConnectionContainerDto> connection;

    public void searchConnections(String from, String to) {
        this.connection = this.connectionRepository.searchConnection(from, to);
    }

    public LiveData<ConnectionContainerDto> getConnections() {
        if (this.connection == null) {
            this.searchConnections("Zürich", "Bern");
        }

        return this.connection;
    }
}
