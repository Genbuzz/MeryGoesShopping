package com.genbuzz.merygoesshopping;

import android.content.Intent;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.MainPresenter;
import screen_contract.MainScreen;

/**
 * keep models and presenters android free
   let the views handle everything that touches UI thread
 */
public class ActivityMain extends AppCompatActivity implements MainScreen, View.OnClickListener {

    @Inject
    MainPresenter mainPresenter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.activity_main_icon_barcode);


    }



   /* @OnClick(R.id.activity_main_icon_barcode)
    public void onListSampleButtonClick(){
        mainPresenter.onShowListButtonClick(this);
    }*/


    @Override
    public void launchFragmentListDetail() {
        Intent intent = new Intent(this, ActivityDetail.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.activity_main_icon_barcode) {
            mainPresenter.onShowListButtonClick(this);
        }

    }
}
