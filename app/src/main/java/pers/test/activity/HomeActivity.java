package pers.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pers.test.R;
import pers.test.adapter.MyGridViewAdapter;
import pers.test.model.HomeIcon;

/**
 * 首页
 */
public class HomeActivity  extends AppCompatActivity {

    @BindView(R.id.MyGridView)
    pers.test.view.MyGridView MyGridView;
    List<HomeIcon> data=new ArrayList<>();
    String[] name={"素质学分","宿舍","心理健康","文明公寓"
            ,"评奖评优","学生活动","上课考勤","请假考勤"
            ,"晚归考勤"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String account = intent.getStringExtra("account");
        String password = intent.getStringExtra("password");

        Toast.makeText(HomeActivity.this, "account = " + account + "; password = " + password,
                Toast.LENGTH_SHORT).show();
        Log.e("tag", "account = " + account + "; password = " + password);

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        for(int i=0;i<9;i++){
            HomeIcon icon=new HomeIcon();
            icon.setIcon(R.mipmap.ic_launcher);
            icon.setIconName(name[i]);
            data.add(icon);
        }

        MyGridView.setAdapter(new MyGridViewAdapter(getApplicationContext(),data));
    }
}

