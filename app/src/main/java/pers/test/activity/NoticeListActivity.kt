package pers.test.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

import java.util.ArrayList

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import pers.test.R
import pers.test.adapter.NoticeListAdapter
import pers.test.model.NoticeInfo

class NoticeListActivity : AppCompatActivity() {

    @BindView(R.id.notice_list)
    lateinit var listView: ListView // List View

    // 存储List View的数据集
    private lateinit var noticeInfos: ArrayList<NoticeInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_list)
        ButterKnife.bind(this@NoticeListActivity)

        val intent = intent
        val bundle = intent.getBundleExtra("bundle")
        noticeInfos = bundle.getSerializable("noticeInfo") as ArrayList<NoticeInfo>

        listView.adapter = NoticeListAdapter(this@NoticeListActivity, noticeInfos)
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@NoticeListActivity, NoticeDetailActivity::class.java)
            intent.putExtra("noticeInfo", noticeInfos[position].toString())
            startActivity(intent)
        }
    }

    @OnClick(R.id.notice_list_back)
    fun onClickBack() {
        onBackPressed()
    }
}
