package jonss.com.github.weatherman.di;

import dagger.Module;
import dagger.Provides;
import jonss.com.github.weatherman.api.DarkSkyService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static jonss.com.github.weatherman.Constants.DARK_SKY_URL;

/**
 * Created by joao on 27/01/17.
 */

@Module
public class WeatherManModule {

    @Provides
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(DARK_SKY_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public DarkSkyService weatherService(Retrofit retrofit) {
        return retrofit.create(DarkSkyService.class);
    }


}
