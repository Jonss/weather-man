package jonss.com.github.weatherman.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import jonss.com.github.weatherman.R;

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

            @Override
            public String toString() {
                return "Weather{" +
                        "summary='" + summary + '\'' +
                        ", icon='" + icon + '\'' +
                        ", time=" + time +
                        ", temperatureMin=" + temperatureMin +
                        ", temperatureMax=" + temperatureMax +
                        '}';
            }

            public int chooseIcon() {
                switch (icon) {
                    case "clear-day":
                        return R.drawable.sun;
                    case "clear-night":
                        return R.drawable.moon;
                    case "rain":
                        return R.drawable.rain;
                    case "snow":
                        return R.drawable.snow;
                    case "sleet":
                        return R.drawable.sleet;
                    case "wind":
                        return R.drawable.fog_day;
                    case "partly-cloudy-day":
                        return R.drawable.partly_cloudy_day;
                    case "partly-cloudy-night":
                        return R.drawable.partly_cloudy_night;
                    case "hail":
                        return R.drawable.hail;
                    case "thunderstorm":
                        return R.drawable.storm;
                    case "tornado":
                        return R.drawable.tornado;
                }
                return R.drawable.sun;
            }

        }
    }
}
