package com.bq.butterknifeexample.ui;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bq.butterknifeexample.basecomponents.activity.InjectableActivity;
import com.bq.butterknifeexample.modules.BindingModule;

import java.util.List;

public class BindingActivity extends InjectableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(android.R.id.content, ItemFragment.newInstance(20), ItemFragment.TAG);
            ft.commit();
        }
    }

    @Override
    protected List<Object> getModules() {
        modules.add(new BindingModule());
        return modules;
    }
}
