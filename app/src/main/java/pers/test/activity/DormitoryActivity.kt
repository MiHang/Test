package pers.test.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import pers.test.R
import pers.test.adapter.DormitoryNavRecyclerAdapter
import pers.test.adapter.DormitoryViewPagerAdapter
import pers.test.callback.DormitoryClickItemListener
import pers.test.fragment.*

class DormitoryActivity : AppCompatActivity() {

    @BindView(R.id.dormitory_header_root)
    lateinit var headerRoot: LinearLayout
    @BindView(R.id.dormitory_back)
    lateinit var back: ImageView
    @BindView(R.id.dormitory_title)
    lateinit var title: TextView
    @BindView(R.id.dormitory_icon)
    lateinit var actionBarIcon: ImageView
    @BindView(R.id.dormitory_divider)
    lateinit var actionDivider: View

    @BindView(R.id.dormitory_recycler_view)
    lateinit var recyclerView: RecyclerView
    @BindView(R.id.dormitory_view_pager)
    lateinit var viewPager: ViewPager

    var items: ArrayList<String> = ArrayList<String>()
    var fragments: ArrayList<Fragment> = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dormitory)
        ButterKnife.bind(this)

        // 更改标题栏
        headerRoot.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        title.setText("全部")
        title.setTextColor(Color.WHITE)
        back.setOnClickListener { onBackPressed() }
        actionDivider.visibility = View.GONE

        // 添加导航栏列表数据
        items.add("全部")
        items.add("来访登记")
        items.add("宿舍走访")
        items.add("卫生登记")
        items.add("维修登记")
        items.add("卫生公示")

        // 交错式网格布局，只显示一行
        var staggerd: StaggeredGridLayoutManager =
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        recyclerView.layoutManager = staggerd

        // 适配器
        var dormitoryNavRecyclerAdapter = DormitoryNavRecyclerAdapter(items)

        // 导航栏点击监听
        dormitoryNavRecyclerAdapter.setOnClickItemListener { position ->
            if (position <= fragments.size - 1) {
                // 切换页面
                viewPager.setCurrentItem(position)
            }
        }

        recyclerView.adapter = dormitoryNavRecyclerAdapter

        // 添加fragment页面数据
        fragments.add(FragmentDormitoryAll())
//        fragments.add(FragmentDormitoryVisitingRegistration())
        fragments.add(FragmentDormitoryHostelVisits())
        fragments.add(FragmentDormitoryHealthRegistration())
        fragments.add(FragmentDormitoryMaintenanceRegistration())
        fragments.add(FragmentDormitoryHealthPublicity())

        // 设置ViewPager适配器
        viewPager.adapter = DormitoryViewPagerAdapter(supportFragmentManager, fragments)
    }

}
