package pers.test.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import pers.test.R
import pers.test.adapter.DormitoryHealthPublicityListAdapter
import pers.test.model.DormitoryHealthPublicityItems

class HealthPublicityDetailActivity : AppCompatActivity() {

    @BindView(R.id.dormitory_back)
    lateinit var back: ImageView
    @BindView(R.id.dormitory_title)
    lateinit var title: TextView
    @BindView(R.id.dormitory_icon)
    lateinit var actionBarIcon: ImageView

    @BindView(R.id.headlth_publicity_detail_list)
    lateinit var detailList: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_publicity_detail)

        ButterKnife.bind(this)

        title.setText("2017年6月22日公示")
        back.setOnClickListener { onBackPressed() }

        var items: ArrayList<DormitoryHealthPublicityItems> = ArrayList<DormitoryHealthPublicityItems>()

        for(i in 1..5) {
            var dormitoryItems = DormitoryHealthPublicityItems()
            dormitoryItems.name = "6栋212室"
            dormitoryItems.manager = "蒋志英"
            dormitoryItems.score = 36f

            items.add(dormitoryItems)
        }

        detailList.adapter = DormitoryHealthPublicityListAdapter(this@HealthPublicityDetailActivity, items)

    }
}
