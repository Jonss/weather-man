package jonss.com.github.weatherman.api;

import jonss.com.github.weatherman.model.DailyWeather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by joao on 27/01/17.
 */

public interface DarkSkyService {

    @GET("/forecast/{apiKey}/{latLong}")
    Call<DailyWeather> getWeeklyForecast(@Path("apiKey") String apiKey,
                                         @Path("latLong") String latLong);
}
