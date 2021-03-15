package ch.paixon.exercise_network_solution;


import ch.paixon.exercise_network_solution.dtos.ConnectionContainerDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConnectionService {

    @GET("connections")
    Call<ConnectionContainerDto> searchConnections(@Query("from") String origin, @Query("to") String destination);

}
