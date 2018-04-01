package pers.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pers.test.R;
import pers.test.adapter.ExcellentStudentRecyclerViewAdapter;
import pers.test.model.ExcellentStudentRecyclerViewModel;

/**
 * 优秀学生activity
 */
public class ExcellentStudentsActivity extends AppCompatActivity {

    @BindView(R.id.excellent_student_recycler_view)
    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excellent_students);

        ButterKnife.bind(this);

        // recyclerView列表数据
        ArrayList<ExcellentStudentRecyclerViewModel> arrayList = new ArrayList<ExcellentStudentRecyclerViewModel>();
        ExcellentStudentRecyclerViewModel excellentStudentRecyclerViewModel = new ExcellentStudentRecyclerViewModel();
        excellentStudentRecyclerViewModel.setTitle("2017年上半学期学院优秀学生名单");
        excellentStudentRecyclerViewModel.setPublishTime("2017.06.29");
        for(int i = 0; i < 6; i++){
            arrayList.add(excellentStudentRecyclerViewModel);
        }

        // 线性布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ExcellentStudentsActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager); // 设置布局管理器
        recyclerView.setAdapter(new ExcellentStudentRecyclerViewAdapter(arrayList)); // 设置适配器
        recyclerView.setItemAnimator(new DefaultItemAnimator()); // 设置 item 动画
    }

    @OnClick(R.id.exc_stu_back_image_view)
    public void onClickBack() {
        onBackPressed();
    }
}
