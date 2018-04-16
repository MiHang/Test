package pers.test.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import pers.test.R;

/**
 * 宿舍 - 来访登记
 */

public class FragmentDormitoryVisitingRegistration extends Fragment {

    private ImageView dormitory_back;
    private TextView dormitory_title;
    private ImageView dormitory_icon;
    private View dormitory_divider;
    private LinearLayout dormitory_header_root;
    private Spinner build;
    private Spinner room;
    private Spinner teacher;
    private Spinner work_kind;
    private Spinner year;
    private Spinner month;
    private Spinner day;
    private EditText visit_content;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dormitory_visiting_registration, null);

        initView(view);

        return view;
    }

    private void initView(View view) {
        dormitory_back = (ImageView) view.findViewById(R.id.dormitory_back);
        dormitory_title = (TextView) view.findViewById(R.id.dormitory_title);
        dormitory_icon = (ImageView) view.findViewById(R.id.dormitory_icon);
        dormitory_divider = (View) view.findViewById(R.id.dormitory_divider);
        dormitory_header_root = (LinearLayout) view.findViewById(R.id.dormitory_header_root);
        build = (Spinner) view.findViewById(R.id.build);
        room = (Spinner) view.findViewById(R.id.room);
        teacher = (Spinner) view.findViewById(R.id.teacher);
        work_kind = (Spinner) view.findViewById(R.id.work_kind);
        year = (Spinner) view.findViewById(R.id.year);
        month = (Spinner) view.findViewById(R.id.month);
        day = (Spinner) view.findViewById(R.id.day);
        visit_content = (EditText) view.findViewById(R.id.visit_content);
    }

}
