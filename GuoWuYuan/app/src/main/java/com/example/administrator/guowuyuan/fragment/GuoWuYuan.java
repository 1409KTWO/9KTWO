package com.example.administrator.guowuyuan.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.guowuyuan.R;

/**
 * Created by Administrator on 2016/10/25.
 */
public class GuoWuYuan extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.guowuyuan_fragment, null);
        return view;
    }
}
