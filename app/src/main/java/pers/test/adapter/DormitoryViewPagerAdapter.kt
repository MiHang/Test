package pers.test.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * 宿舍viewpager适配器
 */
class DormitoryViewPagerAdapter(fm: FragmentManager, fragments: ArrayList<Fragment>) : FragmentPagerAdapter(fm) {

    var fragments: ArrayList<Fragment> = fragments

    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getCount(): Int {
        return fragments.size
    }

}