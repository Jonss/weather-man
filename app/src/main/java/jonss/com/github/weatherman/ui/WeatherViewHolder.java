package jonss.com.github.weatherman.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import jonss.com.github.weatherman.R;
import jonss.com.github.weatherman.model.DailyWeather;

import static jonss.com.github.weatherman.utils.StringUtils.toDecimal;

/**
 * Created by joao on 27/01/17.
 */
public class WeatherViewHolder extends RecyclerView.ViewHolder {

    TextView summaryTemperatureTextView;
    TextView maxTemperatureTextView;
    TextView minTemperatureTextView;

    public WeatherViewHolder(View itemView) {
        super(itemView);
        maxTemperatureTextView = (TextView) itemView.findViewById(R.id.max_temperature_text_view);
        minTemperatureTextView = (TextView) itemView.findViewById(R.id.min_temperature_text_view);
        summaryTemperatureTextView = (TextView) itemView.findViewById(R.id.summary_temperature_text_view);
    }

    public void setWeatherView(DailyWeather.WeatherData.Weather weather) {
        maxTemperatureTextView.setText(toDecimal(weather.getTemperatureMax()));
        minTemperatureTextView.setText(toDecimal(weather.getTemperatureMin()));
        summaryTemperatureTextView.setText(weather.getSummary());
    }



}
