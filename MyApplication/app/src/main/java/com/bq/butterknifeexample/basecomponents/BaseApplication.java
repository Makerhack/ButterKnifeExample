package com.bq.butterknifeexample.basecomponents;

import android.app.Application;
import com.bq.butterknifeexample.AppModule;
import java.util.List;
import dagger.ObjectGraph;

/**
 * Base Activity for all activies
 * Created by Santi on 12/11/2014.
 */
public class BaseApplication extends Application {

    private static BaseApplication sInstance;
    private ObjectGraph objectGraph;

    public static BaseApplication getApp() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        sInstance = this;
        initializeDependencyInjector();
    }

    private void initializeDependencyInjector() {
        objectGraph = ObjectGraph.create(new AppModule(this));
        objectGraph.inject(this);
        objectGraph.injectStatics();
    }

    public ObjectGraph plus(List<Object> modules) {
        if (modules == null) {
            throw new IllegalArgumentException("You can't plus a null module, review your getModules() implementation");
        }
        return objectGraph.plus(modules.toArray());
    }

    public void inject(Object object) {
        objectGraph.inject(object);
    }
}
