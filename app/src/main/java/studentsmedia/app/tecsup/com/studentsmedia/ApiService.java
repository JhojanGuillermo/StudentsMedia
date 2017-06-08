package studentsmedia.app.tecsup.com.studentsmedia;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import studentsmedia.app.tecsup.com.studentsmedia.models.Event;

/**
 * Created by JShanksX13 on 6/06/2017.
 */

public interface ApiService {

    String API_BASE_URL = "https://usuarios-api-martincs27.c9users.io";

    @GET("api/v1/eventos")
    Call<List<Event>> listEvent();

    @GET("api/v1/eventos/{id}")
    Call<Event> getEvent(@Path("id") Integer id);
}
