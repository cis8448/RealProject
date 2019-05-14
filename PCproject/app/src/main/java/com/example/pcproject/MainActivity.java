package com.example.pcproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
//
public class MainActivity extends AppCompatActivity implements FragmentMain.OnTitleSelectedListener{

    FragmentMain fMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fMain = new FragmentMain();
        FragmentTransaction ftrans = getSupportFragmentManager().beginTransaction();
        //l = fin
        ftrans.replace(R.id.frag, fMain);

        ftrans.commit();

    }


    @Override
    public void onTitleSelected(int index) {

    }
}

