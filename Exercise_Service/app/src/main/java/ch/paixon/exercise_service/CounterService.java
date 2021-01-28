package ch.paixon.exercise_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CounterService extends Service {

    // TODO: Create a new Binder which does return this service
    // TODO: Provide a method to get the current counter value

    private int _counter = 0;

    public CounterService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return your binder instance
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void increaseCounter() {
        _counter++;
    }
}