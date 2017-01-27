package jonss.com.github.weatherman;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import jonss.com.github.weatherman.api.DarkSkyService;
import jonss.com.github.weatherman.di.DaggerWeatherManComponent;
import jonss.com.github.weatherman.di.WeatherManComponent;
import jonss.com.github.weatherman.model.DailyWeather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static jonss.com.github.weatherman.Constants.DARK_SKY_API_KEY;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListWeatherActivityFragment extends Fragment {

    public ListWeatherActivityFragment() {
    }

    @Inject
    DarkSkyService darkSkyService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_weather, container, false);

        WeatherManComponent build = DaggerWeatherManComponent.builder().build();
        build.inject(this);

        Call<DailyWeather> weeklyForecast = darkSkyService.getWeeklyForecast(DARK_SKY_API_KEY,
                "37.8267,-122.4233");
        weeklyForecast.enqueue(new Callback<DailyWeather>() {
            @Override
            public void onResponse(Call<DailyWeather> call, Response<DailyWeather> response) {
                System.out.println("" + response.body().getDailyWeatherData().getWeatherDatas());
                Log.d("Ma oeeeee", "");
            }

            @Override
            public void onFailure(Call<DailyWeather> call, Throwable t) {
                Log.d("Deu ruim", t.getMessage());
            }
        });


        return view;
    }
}
