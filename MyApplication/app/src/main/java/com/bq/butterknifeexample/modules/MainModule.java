package com.bq.butterknifeexample.modules;

import android.content.Context;
import android.content.Intent;

import com.bq.butterknifeexample.basecomponents.activity.ActivityContext;
import com.bq.butterknifeexample.ui.BindingActivity;
import com.bq.butterknifeexample.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by seven on 10/02/2016.
 */
@Module(library = true, complete = false, injects = {
        MainActivity.class
})
public class MainModule {

    @Provides
    public Intent provideBindingIntent(@ActivityContext Context context){
        return new Intent(context, BindingActivity.class);
    }
}
