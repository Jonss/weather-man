package jonss.com.github.weatherman.di;

import dagger.Component;
import jonss.com.github.weatherman.ListWeatherActivityFragment;

/**
 * Created by joao on 27/01/17.
 */

@Component(modules = WeatherManModule.class)
public interface WeatherManComponent {

    void inject(ListWeatherActivityFragment listWeatherActivity);
}
