package pers.test.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pers.test.R;
import pers.test.model.HomeIcon;

/**
 * Created by 惠普 on 2018-03-29.
 */

public class MyGridViewAdapter extends BaseAdapter {

    private Context context;
    private List<HomeIcon> lists;//数据源

    public MyGridViewAdapter(Context context, List<HomeIcon> lists) {
        this.context = context;
        this.lists = lists;

    }

    /**
     * 先判断数据及的大小是否显示满本页lists.size() > (mIndex + 1)*mPagerSize
     * 如果满足，则此页就显示最大数量lists的个数
     * 如果不够显示每页的最大数量，那么剩下几个就显示几个
     */
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return lists.size() ;
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return lists.get(arg0 );
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0 ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
        ViewHolder holder = null;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.home_icon, null);
            holder.emoji_text = (TextView)convertView.findViewById(R.id.IconName);
            holder.emoji = (ImageView)convertView.findViewById(R.id.Icon);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.emoji_text.setText(lists.get(position).getIconName());
        holder.emoji.setImageResource(lists.get(position).getIcon());


        return convertView;
    }
    static class ViewHolder{
        private ImageView emoji;
        private TextView emoji_text;
    }

}
