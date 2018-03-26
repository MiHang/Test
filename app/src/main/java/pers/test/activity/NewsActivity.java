package pers.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pers.test.R;
import pers.test.adapter.NewsListViewAdapter;
import pers.test.model.NewsItemData;

/**
 * 新闻列表页面
 */
public class NewsActivity extends AppCompatActivity {

    /**
     * ListView列表
     */
    private ListView listView;
    private List<Map<Integer, NewsItemData>> listMap=new ArrayList<>();
    Map<Integer, NewsItemData> map = new HashMap<Integer, NewsItemData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        // 通过ID获取listView对象
        listView = (ListView)findViewById(R.id.list_view);

        // 定义用于存储list item数据的集合 并为其赋值
        ArrayList<NewsItemData> itemDatas = new ArrayList<NewsItemData>();

        // 初始化自定义类ItemData(该类用于存储每一项list item中的数据), 并为其赋值
        NewsItemData itemData = new NewsItemData();
        itemData.setTitle("学院召开2017党建暨思想政治工作会");
        itemData.setTime("2017年7月21日");
        itemData.setCommentNum("11评");
        itemData.setPublishTime("2分钟前");
        itemData.setIcon(R.mipmap.ic_launcher);
        // 利用for循环为itemDatas集合添加10条重复数据
        for (int i = 0; i < 10; i ++) {
            map.put(i,itemData);

            listMap.add(map);
        }

        // 设置 listView 的适配器
        listView.setAdapter(new NewsListViewAdapter(NewsActivity.this, listMap));

    }

}
