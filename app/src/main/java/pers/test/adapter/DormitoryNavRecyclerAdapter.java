package pers.test.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import pers.test.R;
import pers.test.callback.DormitoryClickItemListener;


/**
 * 宿舍导航栏列表适配器
 */
public class DormitoryNavRecyclerAdapter extends RecyclerView.Adapter<DormitoryNavRecyclerAdapter.ViewHolder>{

    private ArrayList<String> items;

    private DormitoryClickItemListener onClickItemListener;
    public void setOnClickItemListener(DormitoryClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

    public DormitoryNavRecyclerAdapter(ArrayList<String> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dormitory_recycler, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.navName.setText(items.get(position));
        holder.navName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListener.setOnClickItemListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_dormitory_nav_name)
        TextView navName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}