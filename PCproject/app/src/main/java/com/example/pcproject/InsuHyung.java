package com.example.pcproject;

        import android.app.Activity;
        import android.content.Context;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Adapter;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;


public class InsuHyung  extends Fragment {

    //리스트뷰 선언
    ListView lvTitle;
    //어댑터
    ArrayAdapter<String> tAdapter;

    int sIndex = -1; //선택한 항복 번호

    //메인 액티비티에서 상속받아서 재정의하는 통신용 인터페이스
    public  interface  OnTitleSelectedListener {
        public void onTitleSelected(int index);
    }

    public InsuHyung() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_title, container, false);

        lvTitle = rootView.findViewById(R.id.lvTitle);
        //프래그먼트가 속한 액티비티 구하기 : getActivity()
        tAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,Shakespeare.TITLES);

        lvTitle.setAdapter(tAdapter);

        lvTitle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sIndex = position;
                //메인액티비티로 항목 번호 전달
                //메인액티비티의 onTitleSelected() 호출
                //자신이 속한 액티비티를 구하여 호출
                Activity act = getActivity();
                ((OnTitleSelectedListener)act).onTitleSelected(sIndex);
            }
        });

        return rootView;
    }//onCreateView

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        //savedInstanceState 를 불러와서 사용하는 메소드
        //savedInstanceState 는 액티비티가 재시작 할 때
        //onCreate 관련 메소드 사용하는 설정 데이터.
        //설정 데이터를 savedInstanceState 에 추가하려면
        //onSaveInstanceState() 메소드를 사용
        //다시 불러올 때는 onViewStateRestored() 메소드를 사용.
        //savedInstanceState 는 Bundle 객체임.
        //Bundle 객체는 맵(Map) 형태의 데이터 저장 객체.
        //(키, 값) 으로 데이터를 저장.
        if(savedInstanceState != null){
            sIndex = savedInstanceState.getInt("curIndex", -1);

            if(sIndex >= 0) {
                Activity act = getActivity();
                ((OnTitleSelectedListener) act).onTitleSelected(sIndex);

                lvTitle.setSelection(sIndex);
                lvTitle.smoothScrollToPosition(sIndex);
            }
        }
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        //화면이 변경될 때 (앱이 재시작할 경우)
        //화면에 유지하고 싶은 값이 있을 때
        //이 메소드를 사용하여 값을 저장할 수 있음.
        super.onSaveInstanceState(outState);
        outState.putInt("curIndex",sIndex);
    }
}//TitleFragment
