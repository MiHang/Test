package pers.test.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import pers.test.R;
import pers.test.model.ExcellentStudentNameList;
import pers.test.model.ExcellentStudentRecyclerViewModel;

/**
 * 优秀学生名单RecyclerView适配器
 */
public class ExcellentStudentNameListRecyclerViewAdapter
        extends RecyclerView.Adapter<ExcellentStudentNameListRecyclerViewAdapter.ViewHolder> {

    ArrayList<ExcellentStudentNameList> arrayList;

    public ExcellentStudentNameListRecyclerViewAdapter(ArrayList<ExcellentStudentNameList> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_excellent_students_name_list, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.name.setText(arrayList.get(position).getName());
        holder.classes.setText("（" + arrayList.get(position).getClasses() + "）");
        holder.branchCollege.setText(arrayList.get(position).getBranchCollege());
        holder.major.setText(arrayList.get(position).getMajor());

        switch (position) {
            case 0 : {
                holder.serialNumber.setTextColor(Color.parseColor("#ff7936"));
            };break;
            case 1 : {
                holder.serialNumber.setTextColor(Color.parseColor("#ffc657"));
            };break;
            case 2 : {
                holder.serialNumber.setTextColor(Color.parseColor("#ffe670"));
            };break;
        }
        holder.serialNumber.setText(String.valueOf(position + 1));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_serial_number)
        TextView serialNumber; // 序号
        @BindView(R.id.item_name)
        TextView name; // 姓名
        @BindView(R.id.item_classes)
        TextView classes; // 班级
        @BindView(R.id.item_branch_college)
        TextView branchCollege; // 分院
        @BindView(R.id.item_major)
        TextView major; // 专业

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
