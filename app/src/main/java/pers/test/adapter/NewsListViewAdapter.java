package pers.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pers.test.R;
import pers.test.model.NewsItemData;


public class NewsListViewAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Map<Integer,NewsItemData>> itemDatas;

	/**
	* 构造方法
     * @param context
     * @param itemDatas - 用于填充item的数据集合
     */
    public NewsListViewAdapter (Context context, List<Map<Integer, NewsItemData>> itemDatas) {
        this.layoutInflater = LayoutInflater.from(context);
        this.itemDatas = itemDatas;
    }

	/**
	* 返回list item的数量
	*/
    @Override
    public int getCount() {
        return itemDatas.size();
    }

	/**
	* 返回list item
	*/
    @Override
    public Object getItem(int i) {
        return itemDatas.get(i);
    }

	/**
	* 返回list item的ID
	*/
    @Override
    public long getItemId(int i) {
        return i;
    }

	
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;
        Map<Integer, NewsItemData> map = itemDatas.get(i );
		// 初始化item布局
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_news,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else viewHolder = (ViewHolder)view.getTag();

		// 根据集合itemDatas中的内容填充item中显示的数据
        viewHolder.title.setText(map.get(i).getTitle());
        viewHolder.time.setText(map.get(i).getTime());
        viewHolder.comment.setText(map.get(i).getCommentNum());
        viewHolder.publishTime.setText(map.get(i).getPublishTime());
        viewHolder.Icon.setImageResource(map.get(i).getIcon());
        return view;
    }

	/**
	* 用于存储item中的各个控件
	*/
    class ViewHolder {

        public TextView title; // 标题
        public TextView time; // 发布时间
        public TextView comment; // 评论数
        public TextView publishTime; // 发布时间
        public ImageView Icon; // 发布时间
        public ViewHolder (View view) {
            // 通过ID获取相关对象
			title = (TextView)view.findViewById(R.id.title_text_view);
            time = (TextView)view.findViewById(R.id.time_text_view);
            comment = (TextView)view.findViewById(R.id.comment_text_view);
            publishTime = (TextView)view.findViewById(R.id.publish_text_view);
            Icon = (ImageView)view.findViewById(R.id.NewsImg);
        }
    }
}
