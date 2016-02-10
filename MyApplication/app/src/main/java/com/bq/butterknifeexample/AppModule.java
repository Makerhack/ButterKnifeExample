package com.bq.butterknifeexample;

import android.app.Application;


import com.bq.butterknifeexample.basecomponents.BaseApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Module for app level classes
 * Created by Santi on 10/04/2015.
 */
@Module(library = true,
        injects = {
                BaseApplication.class
        })
public class AppModule {
    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    public Application provideApplication() {
        return application;
    }

}
