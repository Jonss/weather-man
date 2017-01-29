package jonss.com.github.weatherman.di;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joao on 28/01/17.
 */

@Module
public class ActivityModule {

    private final Activity context;

    public ActivityModule(Activity context) {
        this.context = context;
    }

    @Provides
    @ActivityScope
    public Context providesListWeatherActivity(){
        return context;
    }

}
