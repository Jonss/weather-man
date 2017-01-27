package jonss.com.github.weatherman.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by joao on 27/01/17.
 */
public class DailyWeather {

    @SerializedName("daily")
    private WeatherData dailyWeatherData;

    public WeatherData getDailyWeatherData() {
        return dailyWeatherData;
    }

    public class WeatherData {

        @SerializedName("data")
        List<Weather> weatherDatas;

        public List<Weather> getWeatherDatas() {
            return weatherDatas;
        }

        private class Weather {
            private String summary;
            private String icon;

            @Override
            public String toString() {
                return summary + " - "+ icon +"\n";
            }
        }
    }
}
