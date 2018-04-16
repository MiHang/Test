package pers.test.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pers.test.R;

public class LoginActivity extends AppCompatActivity {

    EditText account;
    EditText passowrd;
    Button drup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        u.setFullScreen(this);
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
        Drawable acount = getResources().getDrawable(R.drawable.acount);
        Drawable  password = getResources().getDrawable(R.drawable.password);

        acount.setBounds(0, 0, 70, 70);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        password.setBounds(0, 0, 70, 70);
        account.setCompoundDrawables(acount, null, null, null);//只放左边
        passowrd.setCompoundDrawables(password, null, null, null);//只放左边
        drup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoindex = new Intent(LoginActivity.this, HomeActivity.class);
                gotoindex.putExtra("account",account.getText().toString());
                gotoindex.putExtra("password",passowrd.getText().toString());
                startActivity(gotoindex);
                finish();
            }
        });
    }
}
