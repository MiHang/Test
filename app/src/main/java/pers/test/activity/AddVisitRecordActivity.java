package pers.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import pers.test.R;

/**
 * Created by 惠普 on 2018-04-16.
 */

public class AddVisitRecordActivity extends AppCompatActivity {


    private ImageView dormitory_back;
    private TextView dormitory_title;
    private ImageView dormitory_icon;
    private View dormitory_divider;
    private LinearLayout dormitory_header_root;
    private EditText Grade;
    private Spinner build;
    private Spinner room;
    private Spinner year;
    private Spinner month;
    private Spinner day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_visit_record);
        initView();
        dormitory_title.setText("添加走访记录");

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
        Grade = (EditText) findViewById(R.id.Grade);
        build = (Spinner) findViewById(R.id.build);
        room = (Spinner) findViewById(R.id.room);
        year = (Spinner) findViewById(R.id.year);
        month = (Spinner) findViewById(R.id.month);
        day = (Spinner) findViewById(R.id.day);
    }

    private void submit() {
        // validate
        String GradeString = Grade.getText().toString().trim();
        if (TextUtils.isEmpty(GradeString)) {
            Toast.makeText(this, "GradeString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}