package com.tengyun.lesson1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BlankFragment extends Fragment {

    public static final String TEXT = "text";


    public static BlankFragment newInstance(String text) {

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        BlankFragment fragment = new BlankFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    /**
     * 视图创建完成之后执行，用于界面初始化完成之后再修改Ui界面
     * 对ListFragment来说setAdapter必须super.onViewCreated(view, savedInstanceState);执行完之后才会执行。
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv = (TextView) view.findViewById(R.id.tv_fragment);
        String s = getArguments().getString(TEXT);
        tv.setText(s);
    }
}
