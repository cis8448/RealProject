package com.example.pcproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class payspinner extends AppCompatActivity {

    Spinner sp1;

    ArrayList<String> pay = new ArrayList<>();

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay);

        pay.add("금액에 맞게");
        pay.add("2000");
        pay.add("3000");
        pay.add("5000");
        pay.add("10000");
        pay.add("50000");

        sp1 = findViewById(R.id.sp1);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,pay);
        sp1.setAdapter(adapter);

    }
}
