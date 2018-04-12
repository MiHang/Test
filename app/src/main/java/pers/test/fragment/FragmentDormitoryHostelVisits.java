package pers.test.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pers.test.R;

/**
 * 宿舍 - 宿舍走访
 */

public class FragmentDormitoryHostelVisits extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dormitory_hostel_visits, null);

        return view;
    }
}
