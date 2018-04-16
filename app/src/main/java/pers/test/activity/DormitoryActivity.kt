package pers.test.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import pers.test.R
import pers.test.adapter.DormitoryViewPagerAdapter
import pers.test.fragment.*

class DormitoryActivity : AppCompatActivity() {

    // 标题栏
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

    // TabLayout nav导航栏
    @BindView(R.id.dormitory_tab_layout)
    lateinit var tabLayout: TabLayout

    // ViewPager
    @BindView(R.id.dormitory_view_pager)
    lateinit var viewPager: ViewPager

    var fragments: ArrayList<Fragment> = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dormitory)
        ButterKnife.bind(this)

        // 更改标题栏
        headerRoot.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        title.setText("全部")
        title.setTextSize(18f)
        title.setTextColor(Color.WHITE)
        back.setOnClickListener { onBackPressed() }
        actionDivider.visibility = View.GONE

        // 添加fragment页面数据
        fragments.add(FragmentDormitoryAll())
        fragments.add(FragmentDormitoryVisitingRegistration())
        fragments.add(FragmentDormitoryHostelVisits())
        fragments.add(FragmentDormitoryHealthRegistration())
        fragments.add(FragmentDormitoryMaintenanceRegistration())
        fragments.add(FragmentDormitoryHealthPublicity())

        // 设置ViewPager适配器
        viewPager.adapter = DormitoryViewPagerAdapter(supportFragmentManager, fragments)

        // 添加导航栏列表数据
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())

        // 设置TabLayout和ViewPager的联动，该方法必须在设置tab标题之前，否则Tab标题会被清除
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0)!!.text = "全部"
        tabLayout.getTabAt(1)!!.text = "来访登记"
        tabLayout.getTabAt(2)!!.text = "宿舍走访"
        tabLayout.getTabAt(3)!!.text = "卫生登记"
        tabLayout.getTabAt(4)!!.text = "维修登记"
        tabLayout.getTabAt(5)!!.text = "卫生公示"
    }

}
