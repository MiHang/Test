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


public class HomeNoticeListAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;

    private ArrayList<String> arrayList;


    public HomeNoticeListAdapter (Context context, ArrayList<String> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {

            convertView = layoutInflater.inflate(R.layout.item_notice_list, null);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(arrayList.get(position));

        return convertView;
    }

    class ViewHolder {

        @BindView(R.id.item_notice_list_text_view)
        protected TextView textView;

        public ViewHolder(View ItemView) {
            ButterKnife.bind(this, ItemView);
        }
    }

}
