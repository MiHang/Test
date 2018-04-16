package pers.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pers.test.R;

/**
 * 宿舍 - 全部
 */

public class FragmentDormitoryAll extends Fragment {
    RecyclerView dormitory_recycler_all;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dormitory_all, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dormitory_recycler_all = view.findViewById(R.id.dormitory_recycler_all);

    }
}
