package pers.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pers.test.R;
import pers.test.model.DormitoryHealthPublicityItems;

/**
 * 卫生公示详情页
 */

public class DormitoryHealthPublicityListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<DormitoryHealthPublicityItems> items;

    public DormitoryHealthPublicityListAdapter(Context context, ArrayList<DormitoryHealthPublicityItems> items) {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_health_publicity_detail, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else{
            holder = (ViewHolder)convertView.getTag();
        }

        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public TextView itemDormitory;
        public TextView itemDormitoryManager;
        public TextView itemDormitoryScore;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.itemDormitory = (TextView) rootView.findViewById(R.id.item_dormitory);
            this.itemDormitoryManager = (TextView) rootView.findViewById(R.id.item_dormitory_manager);
            this.itemDormitoryScore = (TextView) rootView.findViewById(R.id.item_dormitory_score);
        }

    }
}
