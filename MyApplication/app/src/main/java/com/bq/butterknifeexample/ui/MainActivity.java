package com.bq.butterknifeexample.ui;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bq.butterknifeexample.R;
import com.bq.butterknifeexample.basecomponents.activity.InjectableActivity;
import com.bq.butterknifeexample.modules.MainModule;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends InjectableActivity {

    @Bind(R.id.hello_tv)
    protected TextView helloTv;
    @Bind(R.id.start_bt)
    protected Button startBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected List<Object> getModules() {
        modules.add(new MainModule());
        return modules;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        helloTv.setText(R.string.hello_world);
        startBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FIXME: this could be replaced by butterkinfe @OnClick
                Intent intent = new Intent(MainActivity.this, BindingActivity.class);
                startActivity(intent);
            }
        });
        startBt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //FIXME: this could be replaced by butterkinfe @OnLongClick
                return false;
            }
        });
    }


}
