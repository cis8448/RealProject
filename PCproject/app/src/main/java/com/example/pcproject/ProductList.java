package com.example.pcproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ProductList extends AppCompatActivity {

    ListView proListView;

    @Override
    protected void onResume() {
        super.onResume();
    }

    //ProList 가 존재하여 상품리스트 = ProductList
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        proListView = findViewById(R.id.proListView);

        ArrayList<String> items = new ArrayList<>();
        items.add("라면");
        items.add("콜라");
        items.add("볶음밥");
        items.add("커피");

        CustomAdapter adapter = new CustomAdapter(this, 0, items);
        proListView.setAdapter(adapter);


    }
    private class CustomAdapter extends ArrayAdapter<String> {
        private ArrayList<String> items;
        Context context;

        public CustomAdapter(Context context, int textViewResourceId, ArrayList<String> objects) {
            super(context, textViewResourceId, objects);
            this.context = context;
            this.items = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = View.inflate(context,R.layout.prolistview,null);
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.prolistview, null);
            }

            // ImageView 인스턴스
            ImageView imageView = v.findViewById(R.id.proImage);
            TextView textView1 = v.findViewById(R.id.proTvMount);

            // 리스트뷰의 아이템에 이미지를 변경한다.
            if("라면".equals(items.get(position))) {
                imageView.setImageResource(R.drawable.ramen1);
                textView1.setText("3500원");
            }
            else if("콜라".equals(items.get(position))) {
                imageView.setImageResource(R.drawable.cola);
                textView1.setText("1500원");
            }
            else if("볶음밥".equals(items.get(position))) {
                imageView.setImageResource(R.drawable.rice1);
                textView1.setText("4500원");
            }
            else if("커피".equals(items.get(position))) {
                imageView.setImageResource(R.drawable.coffee);
                textView1.setText("2000원");

            }


            TextView textView = v.findViewById(R.id.proTvName);

            textView.setText(items.get(position));


            final String text = items.get(position);

            return v;
        }
    }
}




