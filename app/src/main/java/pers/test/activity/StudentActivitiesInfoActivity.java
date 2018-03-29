package pers.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class StudentActivitiesInfoActivity extends AppCompatActivity {

    TextView activities_information;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_activities_info);
        initview();
        initData();
    }

    public void initview(){
        activities_information = findViewById(R.id.information);
        time = findViewById(R.id.time);
    }
    public void initData(){
        activities_information.setText("活动内容："+'\n'+"该活动由院团委发起，邀请多家知名企业代表到校为广大创业爱好者提供交流分享讲座。望大家踊跃报名参与，还有精美小礼品哦！！！");
        time.setText('\n'+'\n'+"活动时间："+'\n'+"2017.05.05 15:30 - 2017.05.05 17:30" +'\n'+'\n'+"申请倒计时：剩余3天3小时23分钟");

    }
}
