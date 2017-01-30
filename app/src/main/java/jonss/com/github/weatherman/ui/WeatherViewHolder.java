package jonss.com.github.weatherman.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import jonss.com.github.weatherman.R;
import jonss.com.github.weatherman.model.DailyWeather;

import static jonss.com.github.weatherman.utils.StringUtils.toDecimal;

/**
 * Created by joao on 27/01/17.
 */

public class WeatherViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.summary_temperature_text_view)
    TextView summaryTemperatureTextView;
    @BindView(R.id.max_temperature_text_view)
    TextView maxTemperatureTextView;
    @BindView(R.id.min_temperature_text_view)
    TextView minTemperatureTextView;
    @BindView(R.id.icon_item_image_view)
    ImageView iconImageView;

    public WeatherViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setWeatherView(DailyWeather.WeatherData.Weather weather) {
        System.out.println(weather);
        iconImageView.setImageResource(weather.chooseIcon());
        maxTemperatureTextView.setText(toDecimal(weather.getTemperatureMax()));
        minTemperatureTextView.setText(toDecimal(weather.getTemperatureMin()));
        summaryTemperatureTextView.setText(weather.getSummary());
    }


}
