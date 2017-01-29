package jonss.com.github.weatherman.di;

import dagger.Component;
import jonss.com.github.weatherman.ListWeatherActivityFragment;

/**
 * Created by joao on 27/01/17.
 */
@ActivityScope
@Component(modules = {
        WeatherManModule.class,
        ActivityModule.class
})
public interface WeatherManComponent {

    void inject(ListWeatherActivityFragment listWeatherActivity);
}
