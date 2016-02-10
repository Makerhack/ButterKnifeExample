package com.bq.butterknifeexample.basecomponents.activity;

import android.os.Bundle;

import com.bq.butterknifeexample.basecomponents.BaseApplication;

import java.util.LinkedList;
import java.util.List;

import dagger.ObjectGraph;

public abstract class InjectableActivity extends BaseActivity {
    protected LinkedList<Object> modules = new LinkedList<>();
    private ObjectGraph activityScopeGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        injectDependencies();
        super.onCreate(savedInstanceState);
    }

    private void injectDependencies() {
        List<Object> modules = getModules();
        modules.add(new ActivityModule(this));
        activityScopeGraph = getInjectableApplication().plus(modules);
        inject(this);
    }

    private BaseApplication getInjectableApplication() {
        return (BaseApplication) getApplication();
    }

    public void inject(Object object) {
        activityScopeGraph.inject(object);
    }

    protected abstract List<Object> getModules();

}
