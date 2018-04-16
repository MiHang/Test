package pers.test.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import pers.test.R
import pers.test.adapter.DormitoryNavRecyclerAdapter
import pers.test.adapter.DormitoryViewPagerAdapter
import pers.test.fragment.*
import pers.test.utils.DensityUtil

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
    @BindView(R.id.h_nav_divider)
    lateinit var divider: TextView
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
        title.setTextSize(18f)
        title.setTextColor(Color.WHITE)
        back.setOnClickListener { onBackPressed() }
        actionDivider.visibility = View.GONE

        // 添加导航栏列表数据
        items.add("全    部")
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
                if (position < 2) {
                    var itemWidth = recyclerView.getLayoutManager().getChildAt(1).width
                    recyclerView.scrollBy(itemWidth, 0)
                }
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

        // ViewPager页面改变监听
        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{

            var prevPositionOffset: Float = 0f

            override fun onPageScrollStateChanged(state: Int) { }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                // 前3个导航项移动recyclerView Item
                var itemWidth = recyclerView.getLayoutManager().getChildAt(1).width + 10
                if (positionOffset != 0f && prevPositionOffset != 0f && position < 2) {
                    recyclerView.scrollBy(((positionOffset - prevPositionOffset) * itemWidth).toInt(), 0)
                }

                // 后3个导航项移动divide分割线
                if (positionOffset != 0f && prevPositionOffset != 0f && position >= 2) {

                    var params: LinearLayout.LayoutParams = divider.layoutParams as LinearLayout.LayoutParams
                    params.leftMargin = params.leftMargin + ((positionOffset - prevPositionOffset) * itemWidth).toInt()
                    divider.layoutParams = params

                }

                prevPositionOffset = positionOffset
            }

            override fun onPageSelected(position: Int) {

                when(position) {
                    0 -> {
                        title.setText("全部")
                        recyclerView.scrollToPosition(0)
                        var params: LinearLayout.LayoutParams = divider.layoutParams as LinearLayout.LayoutParams
                        params.leftMargin = DensityUtil.dpToPx(this@DormitoryActivity, 5f)
                        divider.layoutParams = params
                    }
                    1 -> title.setText("来访登记")
                    2 -> title.setText("宿舍走访")
                    3 -> title.setText("卫生登记")
                    4 -> title.setText("维修登记")
                    5 -> title.setText("卫生公示")
                }
            }

        })
    }

}
