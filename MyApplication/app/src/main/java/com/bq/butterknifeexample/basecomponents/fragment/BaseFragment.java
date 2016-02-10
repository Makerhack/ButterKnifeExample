package com.bq.butterknifeexample.basecomponents.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
/**
 * Base class for project Fragments
 * Created by Santi on 12/11/2014.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        Log.d(getClass().getSimpleName(), "Fragment Attached");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Log.d(getClass().getSimpleName(), "Fragment Created");
    }

    protected LayoutInflater getLayoutInflater() {
        return getActivity().getLayoutInflater();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(getClass().getSimpleName(), "Fragment View Created");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(getClass().getSimpleName(), "Fragment Resumed");
    }

    @Override
    public void onPause() {
        Log.d(getClass().getSimpleName(), "Fragment Paused");
        super.onPause();
    }

    @Override
    public void onDetach() {
        Log.d(getClass().getSimpleName(), "Fragment Dettached from Activity");
        super.onDetach();
    }

    protected abstract void refresh();

    public ActionBar getSupportActionBar() {
        AppCompatActivity activity = ((AppCompatActivity) getActivity());
        if (activity != null) {
            ActionBar supportActionBar = activity.getSupportActionBar();
            if (supportActionBar != null) {
                return supportActionBar;
            }
        }
        return null;
    }

    public boolean checkActionBar() {
        FragmentActivity activity = getActivity();
        return activity != null && ((AppCompatActivity) activity).getSupportActionBar() != null;
    }

    /**
     * Checks if the Activity whose this Fragment is Attached is null
     *
     * @return true if the Activity is not null, false otherwise
     */
    public boolean checkActivity() {
        return getActivity() != null;
    }
}
