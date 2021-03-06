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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pers.test.R;
import pers.test.activity.HealthPublicityDetailActivity;
import pers.test.callback.DormitoryClickItemListener;
import pers.test.model.Environment;

/**
 * 宿舍 - 卫生公示
 */

public class FragmentDormitoryHealthPublicity extends Fragment {

    private RecyclerView myVisit;
   List<String> data=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_visit, null);

        initView(view);
        for(int i=0;i<6;i++){
            data.add("2018年");
        }
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        myVisit.setLayoutManager(layoutManager);
        MyAdapter myAdapter=new MyAdapter(getContext(),data);
        myVisit.setAdapter(myAdapter);

        myAdapter.setDormitoryClickItemListener(new DormitoryClickItemListener() {
            @Override
            public void setOnClickItemListener(int position) {
                Intent intent = new Intent(getActivity(), HealthPublicityDetailActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void initView(View view) {
        myVisit = (RecyclerView) view.findViewById(R.id.myVisit);
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        Context context;
        List<String> data;

        private DormitoryClickItemListener dormitoryClickItemListener;
        public void setDormitoryClickItemListener(DormitoryClickItemListener dormitoryClickItemListener) {
            this.dormitoryClickItemListener = dormitoryClickItemListener;
        }

        public MyAdapter(Context context, List<String> data) {
            this.context = context;
            this.data = data;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.notice_item, parent, false);//暂时不将布局文件放入root

            ViewHolder viewHolder = new ViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.Time.setText(data.get(position).toString());
            holder.item_root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dormitoryClickItemListener.setOnClickItemListener(position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public LinearLayout item_root;
            public TextView Time;
            public ImageView More;

            public ViewHolder(View rootView) {
                super(rootView);
                this.item_root = (LinearLayout) rootView.findViewById(R.id.item_notice_root);
                this.Time = (TextView) rootView.findViewById(R.id.Time);
                this.More = (ImageView) rootView.findViewById(R.id.More);
            }
        }
    }

}
