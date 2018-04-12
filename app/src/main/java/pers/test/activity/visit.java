package pers.test.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.LayoutDirection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pers.test.R;
import pers.test.model.VisitInfo;

/**
 * Created by 惠普 on 2018-04-12.
 */

public class visit extends AppCompatActivity {

    @BindView(R.id.myVisit)
    RecyclerView myVisit;
 List<VisitInfo> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_visit);
        ButterKnife.bind(this);
        for(int i=0;i<5;i++){
            VisitInfo v=new VisitInfo();
            v.setContent("走访");
            v.setAddress("成都");
            v.setName("王小二");
            v.setTime("2018");
            v.setId("XXXXXX");
            v.setRelative("父子");
            v.setVisitor("xxx");
            v.setTip("来访登记");
            data.add(v);
        }
        Toast.makeText(this, ""+data.size(), Toast.LENGTH_SHORT).show();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        myVisit.setLayoutManager(layoutManager);
      MyAdapter myAdapter=new MyAdapter(this,data);
        myVisit.setAdapter(myAdapter);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        Context context;
        List<VisitInfo> data;
            public MyAdapter(Context context, List<VisitInfo> data){
                this.context=context;
                this.data=data;
            }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.visit_item,parent,false);//暂时不将布局文件放入root

            ViewHolder viewHolder=new ViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
                  holder.Visitor.setText(data.get(position).getVisitor());
                  holder.Id.setText(data.get(position).getId());
            holder.Tip.setText(data.get(position).getTip());
                    holder.Name.setText(data.get(position).getName());
                    holder.Time.setText(data.get(position).getTime());
            holder.Phone.setText(data.get(position).getPhone());
            holder.record_content.setText(data.get(position).getContent());
            holder.Address.setText(data.get(position).getAddress());
            holder.Relative.setText(data.get(position).getRelative());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            public TextView Visitor;
            public TextView Tip;
            public TextView Name;
            public TextView Time;
            public TextView Phone;
            public TextView Relative;
            public TextView Id;
            public TextView Address;
            public TextView record_content;


            public ViewHolder(View rootView) {
                super(rootView);

                this.Visitor = (TextView) rootView.findViewById(R.id.Visitor);
                this.Tip = (TextView) rootView.findViewById(R.id.Tip);
                this.Name = (TextView) rootView.findViewById(R.id.Name);
                this.Time = (TextView) rootView.findViewById(R.id.Time);
                this.Phone = (TextView) rootView.findViewById(R.id.Phone);
                this.Relative = (TextView) rootView.findViewById(R.id.Relative);
                this.Id = (TextView) rootView.findViewById(R.id.Id);
                this.Address = (TextView) rootView.findViewById(R.id.Address);
                this.record_content = (TextView) rootView.findViewById(R.id.record_content);
            }
        }


    }
}

