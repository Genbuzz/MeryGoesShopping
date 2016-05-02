package com.genbuzz.merygoesshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.MainPresenter;
import screen_contract.MainScreen;


public class ActivityMain extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }



    @OnClick(R.id.activity_main_icon_barcode)
    public void onListSampleButtonClick(){
        mainPresenter.onShowListButtonClick(this);
    }


    @Override
    public void launchFragmentListDetail() {
        Intent intent = new Intent(this, FragmentListDetail.class);
        startActivity(intent);
    }
}
