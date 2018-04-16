package pers.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import pers.test.R;

/**
 * Created by 惠普 on 2018-04-16.
 */

public class VisitRecordActivity extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dormitory_visiting_registration);
        initView();
        dormitory_title.setText("走访登记");
        dormitory_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void initView() {
        dormitory_back = (ImageView) findViewById(R.id.dormitory_back);
        dormitory_title = (TextView) findViewById(R.id.dormitory_title);
        dormitory_icon = (ImageView) findViewById(R.id.dormitory_icon);
        dormitory_divider = (View) findViewById(R.id.dormitory_divider);
        dormitory_header_root = (LinearLayout) findViewById(R.id.dormitory_header_root);
        build = (Spinner) findViewById(R.id.build);
        room = (Spinner) findViewById(R.id.room);
        teacher = (Spinner) findViewById(R.id.teacher);
        work_kind = (Spinner) findViewById(R.id.work_kind);
        year = (Spinner) findViewById(R.id.year);
        month = (Spinner) findViewById(R.id.month);
        day = (Spinner) findViewById(R.id.day);
        visit_content = (EditText) findViewById(R.id.visit_content);
    }


}