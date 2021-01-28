package ch.paixon.exercise_architecture;


import ch.paixon.exercise_architecture.dto.ConnectionContainerDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConnectionService {

    @GET("connections")
    Call<ConnectionContainerDto> searchConnections(@Query("from") String origin, @Query("to") String destination);

}
