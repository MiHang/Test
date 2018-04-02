package pers.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import pers.test.R;
import pers.test.model.NoticeInfo;

/**
 * 公告列表适配器
 */

public class NoticeListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<NoticeInfo> noticeInfos;

    public NoticeListAdapter(Context context, ArrayList<NoticeInfo> noticeInfos) {
        this.inflater = LayoutInflater.from(context);
        this.noticeInfos = noticeInfos;
    }

    @Override
    public int getCount() {
        return noticeInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return noticeInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_notice_list_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(noticeInfos.get(position).getTitle());
        holder.viewTimes.setText("浏览量：" + noticeInfos.get(position).getViewTimes());
        holder.releaseTime.setText(noticeInfos.get(position).getReleaseTime());

        return convertView;
    }

    class ViewHolder {

        @BindView(R.id.item_notice_list_title)
        TextView title;
        @BindView(R.id.item_notice_list_viewTimes)
        TextView viewTimes;
        @BindView(R.id.item_notice_list_releaseTime)
        TextView releaseTime;

        public ViewHolder(View itemView) {
            ButterKnife.bind(this, itemView);
        }

    }
}
