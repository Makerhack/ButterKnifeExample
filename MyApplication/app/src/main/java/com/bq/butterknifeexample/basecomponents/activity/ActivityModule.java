package com.bq.butterknifeexample.basecomponents.activity;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module(library = true)
public final class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideActivityContext() {
        return activity;
    }
}