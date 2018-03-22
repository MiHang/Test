package pers.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import pers.test.R;
import pers.test.adapter.ExcellentStudentNameListRecyclerViewAdapter;
import pers.test.model.ExcellentStudentNameList;

/**
 * 优秀学生名单
 */
public class ExcellentStudentsNameListActivity extends AppCompatActivity {

    @BindView(R.id.excellent_student_name_list_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excellent_students_name_list);

        ButterKnife.bind(this);

        ArrayList<ExcellentStudentNameList> arrayList = new ArrayList<ExcellentStudentNameList>();

        ExcellentStudentNameList excellentStudentNameList = new ExcellentStudentNameList();
        excellentStudentNameList.setName("王媛媛");
        excellentStudentNameList.setClasses("16休闲农业1");
        excellentStudentNameList.setBranchCollege("园林园艺分院");
        excellentStudentNameList.setMajor("休闲农业专业");

        for (int i = 0; i < 8; i ++) {
            arrayList.add(excellentStudentNameList);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new ExcellentStudentNameListRecyclerViewAdapter(arrayList));

    }
}
