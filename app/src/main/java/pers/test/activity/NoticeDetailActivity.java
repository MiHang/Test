package pers.test.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pers.test.R;

public class NoticeDetailActivity extends AppCompatActivity {

    @BindView(R.id.notice_detail_title)
    protected TextView title;
    @BindView(R.id.notice_detail_resource)
    protected TextView resource;
    @BindView(R.id.notice_detail_releaseTime)
    protected TextView releaseTime;
    @BindView(R.id.notice_detail_viewTimes)
    protected TextView viewTimes;
    @BindView(R.id.notice_detail_content)
    protected TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("noticeInfo"));

            title.setText(jsonObject.getString("title"));
            resource.setText(jsonObject.getString("resource"));
            releaseTime.setText(jsonObject.getString("releaseTime"));
            viewTimes.setText("浏览量 : " + jsonObject.getString("viewTimes"));
            content.setText(jsonObject.getString("content"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @OnClick(R.id.notice_detail_back)
    public void onClickBack() {
        onBackPressed();
    }
}
