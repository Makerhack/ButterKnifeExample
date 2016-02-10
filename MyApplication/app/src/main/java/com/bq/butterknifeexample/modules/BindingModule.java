package com.bq.butterknifeexample.modules;

import com.bq.butterknifeexample.dummy.DummyContent;
import com.bq.butterknifeexample.ui.BindingActivity;
import com.bq.butterknifeexample.ui.ItemFragment;
import com.bq.butterknifeexample.ui.TextViewsFragment;

import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by seven on 10/02/2016.
 */
@Module(library = true, complete = false, injects = {
        BindingActivity.class, ItemFragment.class, TextViewsFragment.class
})
public class BindingModule {

    @Provides
    @Singleton
    @Named("first")
    public DummyContent.DummyItem providesDummyItem(){
        return new DummyContent.DummyItem("1", "Santiago", "Masterclass");
    }

    @Provides
    @Singleton
    @Named("second")
    public DummyContent.DummyItem providesSecondDummyItem(){
        return new DummyContent.DummyItem("2", "Santi", "SegundoItem");
    }

    @Provides
    public List<DummyContent.DummyItem> provideDummyItems(){
        return DummyContent.createDummyItems();
    }
}
