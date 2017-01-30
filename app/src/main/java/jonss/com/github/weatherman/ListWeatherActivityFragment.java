package jonss.com.github.weatherman;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import jonss.com.github.weatherman.api.WeatherForecastService;
import jonss.com.github.weatherman.di.ActivityModule;
import jonss.com.github.weatherman.di.DaggerWeatherManComponent;
import jonss.com.github.weatherman.model.DailyWeather;
import jonss.com.github.weatherman.ui.WeatherAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static jonss.com.github.weatherman.utils.Constants.DARK_SKY_API_KEY;
import static jonss.com.github.weatherman.utils.StringUtils.toDecimal;

public class ListWeatherActivityFragment extends Fragment {

    @BindView(R.id.max_today_temperature)
    TextView maxTodayTemperature;
    @BindView(R.id.min_today_temperature)
    TextView minTodayTemperature;
    @BindView(R.id.today_weather_summary)
    TextView summaryTodayTemperature;
    @BindView(R.id.weather_list_recycler_view)
    RecyclerView weatherRecyclerView;

    @Inject
    WeatherAdapter weatherAdapter;

    @Inject
    WeatherForecastService weatherForecastService;

    public ListWeatherActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_weather, container, false);
        ButterKnife.bind(this, view);

        DaggerWeatherManComponent.builder()
                .activityModule(new ActivityModule(getActivity()))
                .build()
                .inject(this);

        weatherRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        weatherRecyclerView.setAdapter(weatherAdapter);

        Call<DailyWeather> weeklyForecast = weatherForecastService.getWeeklyForecast(DARK_SKY_API_KEY,
                "-23.18570,-46.89780");

        weeklyForecast.enqueue(new Callback<DailyWeather>() {
            @Override
            public void onResponse(Call<DailyWeather> call, Response<DailyWeather> response) {
                updateView(response.body().getDailyWeatherData().getWeatherDatas());
                Log.d("Ma oeeeee", "API Funcionou!");
            }

            @Override
            public void onFailure(Call<DailyWeather> call, Throwable t) {
                Log.d("Deu ruim", t.getMessage());
            }
        });

        return view;
    }

    private void updateView(List<DailyWeather.WeatherData.Weather> weatherDatas) {
        maxTodayTemperature.setText(toDecimal(weatherDatas.get(0).getTemperatureMax()));
        minTodayTemperature.setText(toDecimal(weatherDatas.get(0).getTemperatureMin()));
        summaryTodayTemperature.setText(weatherDatas.get(0).getSummary());
        weatherDatas.remove(0);
        weatherAdapter.addAll(weatherDatas);
        weatherRecyclerView.getAdapter().notifyDataSetChanged();
    }
}
