package pers.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pers.test.R;

/**
 * Created by 惠普 on 2018-04-12.
 */

public class AddVisitRecordActivity extends AppCompatActivity {

    @BindView(R.id.dormitory_back)
    ImageView dormitoryBack;
    @BindView(R.id.dormitory_title)
    TextView dormitoryTitle;
    @BindView(R.id.dormitory_icon)
    ImageView dormitoryIcon;
    @BindView(R.id.build)
    Spinner build;
    @BindView(R.id.room)
    Spinner room;
    @BindView(R.id.teacher)
    Spinner teacher;
    @BindView(R.id.work_kind)
    Spinner workKind;
    @BindView(R.id.year)
    Spinner year;
    @BindView(R.id.month)
    Spinner month;
    @BindView(R.id.day)
    Spinner day;
    @BindView(R.id.visit_content)
    EditText visitContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dormitory_visiter);
        ButterKnife.bind(this);
        dormitoryTitle.setText("走访记录");

        dormitoryBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

}

