package jonss.com.github.weatherman.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jonss.com.github.weatherman.ListWeatherActivity;
import jonss.com.github.weatherman.R;
import jonss.com.github.weatherman.model.DailyWeather;

/**
 * Created by joao on 27/01/17.
 */
public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {

    Context context;
    LayoutInflater inflater;
    List<DailyWeather.WeatherData.Weather> weatherDatas;

    @Inject
    public WeatherAdapter(Context context) {
        this.context = context;
        this.weatherDatas = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.weather_item, parent, false);
        WeatherViewHolder weatherViewHolder = new WeatherViewHolder(view);
        return weatherViewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherViewHolder holder, int position) {
        DailyWeather.WeatherData.Weather weather = weatherDatas.get(position);
        holder.setWeatherView(weather);
    }

    @Override
    public int getItemCount() {
        return weatherDatas.size();
    }

    public WeatherAdapter addAll(List<DailyWeather.WeatherData.Weather> weatherDatas) {
        this.weatherDatas.addAll(weatherDatas);
        notifyDataSetChanged();
        return this;
    }

}
