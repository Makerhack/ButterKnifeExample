package com.bq.butterknifeexample.basecomponents.fragment;

import android.app.Activity;
import android.content.Context;

import com.bq.butterknifeexample.basecomponents.activity.InjectableActivity;


/**
 * Base class for project Fragments
 * Created by Santi on 12/11/2014.
 */
public abstract class InjectableFragment extends BaseFragment {

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        injectDependencies();
    }

    private void injectDependencies() {
        ((InjectableActivity) getActivity()).inject(this);
    }

}
