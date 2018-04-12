package pers.test.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pers.test.R;

/**
 * 宿舍 - 卫生登记
 */

public class FragmentDormitoryHealthRegistration extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dormitory_health_registration, null);

        return view;
    }
}
