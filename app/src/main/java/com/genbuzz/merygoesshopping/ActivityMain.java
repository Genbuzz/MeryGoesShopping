package com.genbuzz.merygoesshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import presenter.MainPresenter;
import view.MainView;


public class ActivityMain extends AppCompatActivity implements MainView {

    private MainPresenter mMainPresenter;
    @BindView(R.id.activity_main_icon_barcode) ImageView mBarIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        ButterKnife.bind(this);
        mMainPresenter = new MainPresenter(this);
        mMainPresenter.onCreate();
    }

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void launchActivityDetail() {
        Intent intent = new Intent(this, ActivityDetail.class);
        startActivity(intent);
    }


}
