package ch.paixon.exercise_service_solution;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class CounterService extends Service {

    public class CounterServiceBinder extends Binder {
        public CounterService getService() {
            return CounterService.this;
        }
    }

    private final IBinder _binder = new CounterServiceBinder();

    private int _counter = 0;

    public CounterService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("CounterService", "onBind");
        return _binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("CounterService", "onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.d("CounterService", "onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("CounterService", "onDestroy");
    }

    public void increaseCounter() {
        _counter++;
    }

    public int getCounter() {
        return _counter;
    }
}
