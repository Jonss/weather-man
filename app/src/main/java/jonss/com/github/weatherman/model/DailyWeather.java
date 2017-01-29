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

        public class Weather {
            private String summary;
            private String icon;
            private Long time;
            private Double temperatureMin;
            private Double temperatureMax;

            public String getSummary() {
                return summary;
            }

            public String getIcon() {
                return icon;
            }

            public Long getTime() {
                return time;
            }

            public Double getTemperatureMin() {
                return fahrenheintToCelcius(temperatureMin);
            }

            public Double getTemperatureMax() {
                return fahrenheintToCelcius(temperatureMax);
            }

            private Double fahrenheintToCelcius(Double f) {
                return (f - 32) / 1.8;
            }
        }
    }
}
