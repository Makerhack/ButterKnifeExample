package com.bq.butterknifeexample.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bq.butterknifeexample.R;
import com.bq.butterknifeexample.basecomponents.fragment.InjectableFragment;
import com.bq.butterknifeexample.dummy.DummyContent;


public class TextViewsFragment extends InjectableFragment {


    private static final String KEY_ITEM = "item";
    private DummyContent.DummyItem item;

    protected TextView idTv;
    protected TextView contentTv;
    protected TextView detailsTv;

    // TODO: Rename and change types and number of parameters
    public static TextViewsFragment newInstance(DummyContent.DummyItem item) {
        TextViewsFragment fragment = new TextViewsFragment();
        Bundle args = new Bundle();
        args.putParcelable(KEY_ITEM,item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = getArguments().getParcelable(KEY_ITEM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_text_views, container, false);
        idTv = (TextView) v.findViewById(R.id.id_tv);
        contentTv = (TextView) v.findViewById(R.id.content_tv);
        detailsTv = (TextView) v.findViewById(R.id.details_tv);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        idTv.setText(item.getId());
        contentTv.setText(item.getContent());
        detailsTv.setText(item.getDetails());
        contentTv.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        detailsTv.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        idTv.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));

    }

    @Override
    protected void refresh() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
