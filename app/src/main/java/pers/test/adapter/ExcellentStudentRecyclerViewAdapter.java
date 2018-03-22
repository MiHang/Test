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
import pers.test.model.ExcellentStudentRecyclerViewModel;

/**
 * 优秀学生RecyclerView适配器
 */
public class ExcellentStudentRecyclerViewAdapter extends RecyclerView.Adapter<ExcellentStudentRecyclerViewAdapter.ViewHolder> {

    ArrayList<ExcellentStudentRecyclerViewModel> arrayList;

    public ExcellentStudentRecyclerViewAdapter(ArrayList<ExcellentStudentRecyclerViewModel> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_excellent_students, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.title.setText(arrayList.get(position).getTitle());
        holder.publishTime.setText(arrayList.get(position).getPublishTime());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_title)
        TextView title;
        @BindView(R.id.item_publish_time)
        TextView publishTime;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
