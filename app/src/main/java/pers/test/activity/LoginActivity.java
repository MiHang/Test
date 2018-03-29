package pers.test.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pers.test.Comment.CommonUtil;
import pers.test.R;

public class LoginActivity extends AppCompatActivity {

    EditText account;
    EditText passowrd;
    Button drup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CommonUtil.setFullScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initview();

    }


    public void initview(){

        //绑定控件
        account = findViewById(R.id.account);
        passowrd = findViewById(R.id.password);
        drup = findViewById(R.id.drup);

        //控制登录用户名图标大小
        Drawable drawable1 = getResources().getDrawable(R.mipmap.ic_launcher);

        drawable1.setBounds(0, 0, 100, 100);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        passowrd.setCompoundDrawables(drawable1, null, null, null);//只放左边
        account.setCompoundDrawables(drawable1, null, null, null);//只放左边
        drup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoindex = new Intent(LoginActivity.this,StudentActivitiesInfoActivity.class);
                gotoindex.putExtra("account",account.getText());
                gotoindex.putExtra("passowrd",passowrd.getText());
                startActivity(gotoindex);
                finish();
            }
        });
    }
}
