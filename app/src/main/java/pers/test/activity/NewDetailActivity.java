package pers.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pers.test.R;


public class NewDetailActivity extends AppCompatActivity {

    @BindView(R.id.Back)
    ImageView Back;
    @BindView(R.id.Title)
    TextView Title;
    @BindView(R.id.biaoti)
    TextView biaoti;
    @BindView(R.id.dizhi)
    TextView dizhi;
    @BindView(R.id.read)
    ImageView read;
    @BindView(R.id.readnum)
    TextView readnum;
    @BindView(R.id.day)
    TextView day;
    @BindView(R.id.leirong)
    TextView leirong;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.leirong1)
    TextView leirong1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        //从Intent当中根据key取得value
        if (intent != null) {
            String value = intent.getStringExtra("title");
            Title.setText(value);
        }
    }

    @OnClick(R.id.Back)
    public void onClickBack() {
        onBackPressed();
    }

}
