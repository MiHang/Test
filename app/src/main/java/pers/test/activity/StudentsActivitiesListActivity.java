package pers.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import pers.test.R;

public class StudentsActivitiesListActivity extends AppCompatActivity {

    private TextView activities_title_bar;
    private ListView studentactivities_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_activities_list);
        initView();
        listAdapter();
    }

    public void initView(){
        activities_title_bar = findViewById(R.id.activities_title_bar);
        studentactivities_listview = findViewById(R.id.activities_list);
    }


    public void listAdapter(){

        studentactivities_listview.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 10;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int positon, View convertview, ViewGroup parent) {
                View view;
                if(convertview == null){
                    view = View.inflate(getBaseContext(),R.layout.item_studentactivities_list,null);
                }else {
                    view = convertview;
                }
                TextView activities_title = view.findViewById(R.id.activities_title);
                TextView activities_type = view.findViewById(R.id.activities_type);
                TextView start_time = view.findViewById(R.id.start_time);
                TextView apply_time = view.findViewById(R.id.apply_time);
                activities_title.setText("大学生SYB创业活动讲座");
                activities_type.setText("团委活动");
                start_time.setText("活动时间：2017.05.05 15:30 - 2017.05.05 17:30");
                apply_time.setText("申请时间：2017.05.01 00:00 - 2017.05.04 23:59");
                return view;
            }
        });

        studentactivities_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(StudentsActivitiesListActivity.this,StudentActivitiesInfoActivity.class);
                startActivity(intent);
            }
        });
    }

}
