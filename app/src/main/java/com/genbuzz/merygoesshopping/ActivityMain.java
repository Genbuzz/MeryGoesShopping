package com.genbuzz.merygoesshopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/**
 * keep models and presenters android free
   let the views handle everything that touches UI thread
 */
public class ActivityMain extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }






}
