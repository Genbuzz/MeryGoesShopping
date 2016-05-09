package com.genbuzz.merygoesshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import javax.inject.Inject;

import presenter.MainPresenter;
import view.MainScreen;

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
    imageView.setOnClickListener(this);

    }





    public void onListSampleButtonClick(){
        mainPresenter.onShowListButtonClick(this);
    }


    @Override
    public void launchFragmentListDetail() {
        Intent intent = new Intent(this, ActivityDetail.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.activity_main_icon_barcode) {
          launchFragmentListDetail();
           /* Toast.makeText(getApplicationContext(), "Disparado", Toast.LENGTH_LONG).show();*/
        }

    }
}
