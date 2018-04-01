package pers.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pers.test.R;
import pers.test.adapter.HomeExStuListAdapter;
import pers.test.adapter.HomeNewsListAdapter;
import pers.test.adapter.HomeNoticeListAdapter;
import pers.test.adapter.MyGridViewAdapter;
import pers.test.model.HomeIcon;
import pers.test.view.MyGridView;
import pers.test.view.MyListView;

/**
 * 首页
 */
public class HomeActivity  extends AppCompatActivity {

    @BindView(R.id.MyGridView)
    MyGridView myGridView;
    List<HomeIcon> data=new ArrayList<>();


    @BindView(R.id.home_notice_root)
    protected LinearLayout noticeRoot;
    @BindView(R.id.home_notice_list)
    protected MyListView noticeList;

    @BindView(R.id.home_news_root)
    protected LinearLayout newsRoot;
    @BindView(R.id.home_news_list)
    protected MyListView newsList;

    @BindView(R.id.home_exstu_root)
    protected LinearLayout exstuRoot;
    @BindView(R.id.home_exstu_list)
    protected MyListView exstuList;

    @BindView(R.id.home_stuac_root)
    protected LinearLayout stuacRoot;
    @BindView(R.id.home_stuac_list)
    protected MyListView stuacList;

    @BindView(R.id.home_ciap_root)
    protected LinearLayout ciapRoot;
    @BindView(R.id.home_ciap_list)
    protected MyListView ciapList;


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

        /*************** 首页GridView ******************/
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        int[] icon={
                R.drawable.suzhixuefen,
                R.drawable.sushe,
                R.drawable.xinlijiankang,
                R.drawable.wenminggongyu,
                R.drawable.pingjinagpingyou,
                R.drawable.xueshenghuodong,
                R.drawable.shangkekaoqin,
                R.drawable.qingjiakaoqin,
                R.drawable.wanguikaoqin
        };
        String[] name={"素质学分","宿舍","心理健康","文明公寓"
                ,"评奖评优","学生活动","上课考勤","请假考勤"
                ,"晚归考勤"
        };
        for(int i=0;i<9;i++){
            HomeIcon HomeIcon=new HomeIcon();
            HomeIcon.setIcon(icon[i]);
            HomeIcon.setIconName(name[i]);
            data.add(HomeIcon);
        }
        myGridView.setAdapter(new MyGridViewAdapter(getApplicationContext(),data));

        /*************** 首页相关推荐 公告 列表******************/
        final String[] notice={
                "关于2017暑假有关事项通知"
                ,"7栋寝室维修情况公示",
                "2017年优秀辅导员评选结果公示",
                "2017年工勤人员考试公示",
        };
        ArrayList<String> noticeListArray = new ArrayList<String>();
        for (int i = 0; i < notice.length; i ++) {
            noticeListArray.add(notice[i]);
        }
        noticeList.setAdapter(new HomeNoticeListAdapter(HomeActivity.this, noticeListArray));
        noticeList.setListViewHeightBasedOnChildren();
        noticeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this, NewDetailActivity.class);
                intent.putExtra("title",notice[position]);
                startActivity(intent);
            }
        });

        /*************** 首页相关推荐 新闻 列表******************/
        final String[] news={
                "学院召开中层干部会议部署假期及开学工作",
                "热烈庆祝学院圆满完成2017年上半年学历农活动",
                "热烈庆祝首届国际教育联盟农业嘉年华活动展开",
                "牧医系首届裕康原奖学金颁奖仪式",
        };
        ArrayList<String> newsListArray = new ArrayList<String>();
        for (int i = 0; i <news.length; i ++) {
            newsListArray.add(news[i]);
        }
        newsList.setAdapter(new HomeNewsListAdapter(HomeActivity.this, newsListArray));
        newsList.setListViewHeightBasedOnChildren();
        newsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(HomeActivity.this, NewDetailActivity.class);
                intent.putExtra("title",news[position]);
                startActivity(intent);

            }
        });

        /*************** 首页相关推荐 优秀学生 列表******************/
        ArrayList<String> exStuListArray = new ArrayList<String>();
        for (int i = 0; i < 4; i ++) {
            exStuListArray.add("2017上半学年优秀学生名单");
        }
        exstuList.setAdapter(new HomeExStuListAdapter(HomeActivity.this, exStuListArray));
        exstuList.setListViewHeightBasedOnChildren();
        exstuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this, ExcellentStudentsNameListActivity.class);
                startActivity(intent);
            }
        });

        /*************** 首页相关推荐 学生活动 列表******************/
        ArrayList<String> stuacListArray = new ArrayList<String>();
        for (int i = 0; i < 4; i ++) {
            stuacListArray.add("2017上半学年优秀学生名单");
        }
        stuacList.setAdapter(new HomeExStuListAdapter(HomeActivity.this, stuacListArray));
        stuacList.setListViewHeightBasedOnChildren();
        stuacList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this, StudentActivitiesInfoActivity.class);
                startActivity(intent);
            }
        });

        /*************** 首页相关推荐 g公寓管理 列表******************/
        ArrayList<String> ciapListArray = new ArrayList<String>();
        for (int i = 0; i < 4; i ++) {
            ciapListArray.add("2017上半学年优秀学生名单");
        }
        ciapList.setAdapter(new HomeExStuListAdapter(HomeActivity.this, ciapListArray));
        ciapList.setListViewHeightBasedOnChildren();
    }

    /**
     * 点击更多学生活动，跳转页面
     */
    @OnClick(R.id.home_stuac_list_more)
    public void onClickStuacListMore() {
        Intent intent = new Intent(HomeActivity.this, StudionActivitiesListActivity.class);
        startActivity(intent);
    }


    /**
     * 点击更多文明寝室，跳转页面
     */
    @OnClick(R.id.home_ciap_list_more)
    public void onClickCiapListMore() {
        // Intent intent = new Intent(HomeActivity.this, )
    }

    /**
     * 点击更多优秀学生，跳转页面
     */
    @OnClick(R.id.home_exstu_list_more)
    public void onClickExstusListMore() {
        Intent intent = new Intent(HomeActivity.this, ExcellentStudentsActivity.class);
        startActivity(intent);
    }


    /**
     * 点击更多新闻，跳转页面
     */
    @OnClick(R.id.home_news_list_more)
    public void onClickNewsListMore() {
        Intent intent = new Intent(HomeActivity.this, NewsActivity.class);
        startActivity(intent);
    }


    /**
     * 点击更多公告，跳转页面
     */
    @OnClick(R.id.home_notice_list_more)
    public void onClickNoticeListMore() {
        Intent intent = new Intent(HomeActivity.this, NewsActivity.class);
        startActivity(intent);
    }


    /**
     * 折叠/展开文明寝室
     */
    @OnClick(R.id.home_ciap_more)
    public void OnClickCiapMore() {

        if (ciapRoot.getVisibility() == View.GONE) {
            ciapRoot.setVisibility(View.VISIBLE);
        } else {
            ciapRoot.setVisibility(View.GONE);
        }
    }


    /**
     * 折叠/展开学生活动
     */
    @OnClick(R.id.home_stuac_more)
    public void OnClickStuacMore() {

        if (stuacRoot.getVisibility() == View.GONE) {
            stuacRoot.setVisibility(View.VISIBLE);
        } else {
            stuacRoot.setVisibility(View.GONE);
        }
    }


    /**
     * 折叠/展开优秀学生
     */
    @OnClick(R.id.home_exstu_more)
    public void OnClickExStuMore() {

        if (exstuRoot.getVisibility() == View.GONE) {
            exstuRoot.setVisibility(View.VISIBLE);
        } else {
            exstuRoot.setVisibility(View.GONE);
        }
    }

    /**
     * 折叠/展开新闻
     */
    @OnClick(R.id.home_news_more)
    public void OnClickNewsMore() {

        if (newsRoot.getVisibility() == View.GONE) {
            newsRoot.setVisibility(View.VISIBLE);
        } else {
            newsRoot.setVisibility(View.GONE);
        }
    }

    /**
     * 折叠/展开公告
     */
    @OnClick(R.id.home_notice_more)
    public void OnClickNoticeMore() {

        if (noticeRoot.getVisibility() == View.GONE) {
            noticeRoot.setVisibility(View.VISIBLE);
        } else {
            noticeRoot.setVisibility(View.GONE);
        }

    }

}

