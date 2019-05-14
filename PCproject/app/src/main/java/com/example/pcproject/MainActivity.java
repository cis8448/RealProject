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
        Intent intents = new Intent(MainActivity.this, ProductList.class);
        startActivity(intents);

    }


    @Override
    public void onTitleSelected(int index) {
        
    }
}

