package pers.test.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pers.test.R;
import pers.test.adapter.NoticeListAdapter;
import pers.test.model.NoticeInfo;

public class NoticeListActivity extends AppCompatActivity {

    @BindView(R.id.notice_list)
    protected ListView listView;

    private ArrayList<NoticeInfo> noticeInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_list);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        noticeInfos = (ArrayList<NoticeInfo>) bundle.getSerializable("noticeInfo");

        listView.setAdapter(new NoticeListAdapter(NoticeListActivity.this, noticeInfos));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NoticeListActivity.this, NoticeDetailActivity.class);
                intent.putExtra("noticeInfo",noticeInfos.get(position).toString());
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.notice_list_back)
    public void onClickBack() {
        onBackPressed();
    }
}
