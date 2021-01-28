package ch.paixon.exercise_location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    private TextView longitudeTextView;
    private TextView latitudeTextView;
    private FusedLocationProviderClient client;

    // TODO Implement the LocationCallback-Class
    private LocationCallback locationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Einfache Implementation um die Permissions für den Location-Zugriff zu erhalten
        // Fehlerhandling fehlt komplett -> App crashed wenn der Benutzer die Berechtigungen nicht erteilt
        // Mehr zu Fehlerhandling unter folgendem Link:
        // https://developer.android.com/training/permissions/requesting.html
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);

        longitudeTextView = findViewById(R.id.valueLongitude);
        latitudeTextView = findViewById(R.id.valueLatitude);

        // TODO: Get the FusedLocationProviderClient instance
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        // TODO Use the getLastLocation() method on the client to get the last known location

        // TODO Create a new LocationRequest and request location updates
    }

    @Override
    protected void onPause() {
        super.onPause();

        // TODO Do not forget to remove the location listener
    }

    private void UpdateLocationOnUi(Location location) {
        if (location != null) {
            latitudeTextView.setText(location.getLatitude() + "");
            longitudeTextView.setText(location.getLongitude() + "");
        }
    }
}
