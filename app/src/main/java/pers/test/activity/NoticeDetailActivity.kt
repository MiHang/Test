package pers.test.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import org.json.JSONException
import org.json.JSONObject

import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import pers.test.R

/**
 * 公告详情页
 */
class NoticeDetailActivity : AppCompatActivity() {

    @BindView(R.id.notice_detail_title)
    lateinit var title: TextView
    @BindView(R.id.notice_detail_resource)
    lateinit var resource: TextView
    @BindView(R.id.notice_detail_releaseTime)
    lateinit var releaseTime: TextView
    @BindView(R.id.notice_detail_viewTimes)
    lateinit var viewTimes: TextView
    @BindView(R.id.notice_detail_content)
    lateinit var content: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notice_detail)
        ButterKnife.bind(this@NoticeDetailActivity)

        val intent = intent
        try {
            val jsonObject = JSONObject(intent.getStringExtra("noticeInfo"))

            title.text = jsonObject.getString("title")
            resource.text = jsonObject.getString("resource")
            releaseTime.text = jsonObject.getString("releaseTime")
            viewTimes.text = "浏览量 : " + jsonObject.getString("viewTimes")
            content.text = jsonObject.getString("content")

        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    @OnClick(R.id.notice_detail_back)
    fun onClickBack() {
        onBackPressed()
    }
}
