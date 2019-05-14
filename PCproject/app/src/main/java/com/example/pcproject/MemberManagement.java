package com.example.pcproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MemberManagement extends AppCompatActivity {

    ListView mList;

    @Override
    protected void onResume() {
        super.onResume();
    }

    //ProList 가 존재하여 상품리스트 = ProductList
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_management);

         mList = findViewById(R.id.mList);

        ArrayList<String> items = new ArrayList<>();
        items.add("이름");
        items.add("생년월일");
        items.add("아이디");
        items.add("적립시간");

        CustomAdapter adapter = new CustomAdapter(this, 0, items);
        mList.setAdapter(adapter);


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
            View v = View.inflate(context,R.layout.member_management2,null);
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.member_management2, null);
            }

            // ImageView 인스턴스
            TextView textView1 = v.findViewById(R.id.mName);
            TextView textView2 = v.findViewById(R.id.mDb);
            TextView textView3 = v.findViewById(R.id.mId);
            TextView textView4 = v.findViewById(R.id.mTime);


            // 리스트뷰의 아이템에 이미지를 변경한다.
            if("이름".equals(items.get(position))) {
                textView1.setText("name");
                textView2.setText("db");
                textView3.setText("id");
                textView4.setText("time");
            }
            if("생년월일".equals(items.get(position))) {
                textView1.setText("name");
                textView2.setText("db");
                textView3.setText("id");
                textView4.setText("time");
            }
             if("아이디".equals(items.get(position))) {
                textView1.setText("name");
                textView2.setText("db");
                textView3.setText("id");
                textView4.setText("time");
            }
            if("적립시간".equals(items.get(position))) {
                textView1.setText("name");
                textView2.setText("db");
                textView3.setText("id");
                textView4.setText("time");

            }



            final String text = items.get(position);

            return v;
        }
    }
}
