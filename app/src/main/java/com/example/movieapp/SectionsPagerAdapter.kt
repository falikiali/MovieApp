package com.example.movieapp

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.movieapp.home.HomeFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.fav_movie)
    }

    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> HomeFragment()
            1 -> getFavoriteFragment()!!
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = mContext.resources.getString(TAB_TITLES[position])

    private fun getFavoriteFragment() : Fragment? {
        return try {
            Class.forName("com.example.favorite.FavoriteFragment").newInstance() as Fragment
        } catch (ex: Exception) {
            null
        }
    }
}