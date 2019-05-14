package com.example.pcproject;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements FragmentMain.OnTitleSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Intent intent = new Intent(MainActivity.this, payspinner.class);

        startActivity(intent);


    }


    @Override
    public void onTitleSelected(int index) {
        if(getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE){
            //가로방향에 대한 처리
            DetailFragment deFrag = new DetailFragment();
            //DetailFragment 에 선택 값 전달.
            deFrag.setSelection(index);

            getSupportFragmentManager().beginTransaction().replace(R.id.detail, deFrag).commit();
        }
        else {
            //세로 방향에 대한 처리
            Intent it = new Intent(this, DetailActivity.class);
            it.putExtra("index",index);
            startActivity(it);
    }
}

