package pers.test.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import pers.test.R

/**
 * 宿舍导航栏列表适配器
 */
class DormitoryNavRecyclerAdapter(items: ArrayList<String>)
    : RecyclerView.Adapter<DormitoryNavRecyclerAdapter.ViewHolder>() {

    var items: ArrayList<String> = items

    // 点击控件监听
    interface OnClickItemListener {
        fun setOnClickItemListener(position: Int)
    }
    lateinit var onClickItemListener: OnClickItemListener
    fun addOnClickItemListener(onClickItemListener: OnClickItemListener) {
        this.onClickItemListener = onClickItemListener
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent!!.context)
                .inflate(R.layout.item_dormitory_recycler, parent, false)
        val holder = ViewHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.navName.setText(items.get(position))
        holder!!.navName.setOnClickListener {
            onClickItemListener.setOnClickItemListener(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.item_dormitory_nav_name)
        lateinit var navName: TextView

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}