package jonss.com.github.weatherman.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import jonss.com.github.weatherman.api.WeatherForecastService;
import jonss.com.github.weatherman.ui.adapter.WeatherAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static jonss.com.github.weatherman.utils.Constants.DARK_SKY_URL;

/**
 * Created by joao on 27/01/17.
 */

@Module(includes = ActivityModule.class)
public class WeatherManModule {

    @Provides
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(DARK_SKY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public WeatherForecastService weatherService(Retrofit retrofit) {
        return retrofit.create(WeatherForecastService.class);
    }

    @Provides
    public WeatherAdapter providesWeatherAdapter(Context context){
        return new WeatherAdapter(context);
    }


}
