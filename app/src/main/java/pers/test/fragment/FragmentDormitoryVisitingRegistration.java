package pers.test.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pers.test.R;
import pers.test.activity.AddVisitRecordActivity;
import pers.test.activity.VisitRecordActivity;
import pers.test.model.VisitInfo;

/**
 * 宿舍 - 来访登记
 */

public class FragmentDormitoryVisitingRegistration extends Fragment {

    private RecyclerView myVisit;
    List<VisitInfo> data = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_visit, null);

        initView(view);
        for (int i = 0; i < 5; i++) {
            VisitInfo v = new VisitInfo();
            v.setContent("走访");
            v.setAddress("成都");
            v.setName("王小二");
            v.setTime("2018");
            v.setVisit_Title("常规宿舍走访");
            v.setTip("来访登记");
            data.add(v);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        myVisit.setLayoutManager(layoutManager);
        MyAdapter myAdapter = new MyAdapter(getContext(), data);
        myVisit.setAdapter(myAdapter);
        myAdapter.setItemListener(new MyAdapter.setItemListener() {
            @Override
            public void Item(View v, int position) {
                Toast.makeText(getContext(), "" + position, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), AddVisitRecordActivity.class));
            }
        });

        return view;
    }

    private void initView(View view) {
        myVisit = (RecyclerView) view.findViewById(R.id.myVisit);
    }

    static class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener {
        Context context;
        List<VisitInfo> data;
        setItemListener itemListener;

        public setItemListener getItemListener() {
            return itemListener;
        }

        public void setItemListener(setItemListener itemListener) {
            this.itemListener = itemListener;
        }

        public interface setItemListener {
            void Item(View v, int position);
        }

        public MyAdapter(Context context, List<VisitInfo> data) {
            this.context = context;
            this.data = data;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.visit_item, parent, false);//暂时不将布局文件放入root

            ViewHolder viewHolder = new ViewHolder(view);
            view.setOnClickListener(this);


            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.Visitor.setText(data.get(position).getVisit_Title());
            holder.Tip.setText(data.get(position).getTip());
            holder.Name.setText(data.get(position).getName());
            holder.Time.setText(data.get(position).getTime());
            holder.record_content.setText(data.get(position).getContent());
            holder.Address.setText(data.get(position).getAddress());
            holder.itemView.setTag(position);


        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @Override
        public void onClick(View view) {
            if (itemListener != null) {
                if (view.getTag() != null) {
                    itemListener.Item(view, (int) view.getTag());
                }

            }
        }


        class ViewHolder extends RecyclerView.ViewHolder{

            public TextView Visitor;
            public TextView Tip;
            public TextView Name;
            public TextView Time;
            public TextView Address;
            public TextView record_content;

            public ViewHolder(View rootView) {
                super(rootView);
                this.Visitor = (TextView) rootView.findViewById(R.id.Visitor);
                this.Tip = (TextView) rootView.findViewById(R.id.Tip);
                this.Name = (TextView) rootView.findViewById(R.id.Name);
                this.Time = (TextView) rootView.findViewById(R.id.Time);
                this.Address = (TextView) rootView.findViewById(R.id.Address);
                this.record_content = (TextView) rootView.findViewById(R.id.record_content);
            }

        }
    }
}
