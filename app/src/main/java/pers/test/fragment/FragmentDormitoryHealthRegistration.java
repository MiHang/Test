package pers.test.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pers.test.R;

import pers.test.model.Environment;

/**
 * 宿舍 - 卫生登记
 */

public class FragmentDormitoryHealthRegistration extends Fragment {

    private RecyclerView myVisit;
    List<Environment> data=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_visit, null);

        initView(view);
        Random random = new Random();
        String red;
        for(int i=0;i<6;i++){
            Environment e=new Environment();
            e.setGrade("50");
            e.setTip("卫生登记");
            e.setName("xxx");
            e.setAddress("1栋2室");
            red = Integer.toHexString(random.nextInt(256)).toUpperCase();
            e.setColor(red);
            data.add(e);
        }
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        myVisit.setLayoutManager(layoutManager);
        MyAdapter myAdapter=new MyAdapter(getContext(),data);
        myVisit.setAdapter(myAdapter);
        return view;
    }

    private void initView(View view) {
        myVisit = (RecyclerView) view.findViewById(R.id.myVisit);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        Context context;
        List<Environment> data;

        public MyAdapter(Context context, List<Environment> data) {
            this.context = context;
            this.data = data;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.en_item, parent, false);//暂时不将布局文件放入root

           ViewHolder viewHolder = new ViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.Tip.setText(data.get(position).getTip());
            holder.Name.setText(data.get(position).getName());
            holder.Time.setText(data.get(position).getTime());
            holder.Address.setText(data.get(position).getAddress());
            holder.Grade.setText(data.get(position).getGrade());
            holder.Grade.setTextColor(Color.RED);
        }


        @Override
        public int getItemCount() {
            return data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {


            public TextView Address;
            public TextView Tip;
            public TextView Name;
            public TextView Time;
            public TextView Grade;

            public ViewHolder(View rootView) {
                super(rootView);
                this.Address = (TextView) rootView.findViewById(R.id.Address);
                this.Tip = (TextView) rootView.findViewById(R.id.Tip);
                this.Name = (TextView) rootView.findViewById(R.id.Name);
                this.Time = (TextView) rootView.findViewById(R.id.Time);
                this.Grade = (TextView) rootView.findViewById(R.id.Grade);
            }
        }


    }
}
