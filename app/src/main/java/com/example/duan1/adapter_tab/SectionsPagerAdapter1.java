package com.example.duan1.adapter_tab;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.duan1.KhachHang.likeFragment.historyFragment;
import com.example.duan1.KhachHang.likeFragment.yeuthichFragment;
import com.example.duan1.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter1 extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab1,R.string.tab2};
    // thông số thay đổi



    public SectionsPagerAdapter1(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
      FragmentPagerAdapter fragmentPagerAdapter1;
      Fragment fragment = null;
      switch (position){
          case  0:
              fragment = new yeuthichFragment();
                    break;
          case  1:
              fragment = new historyFragment();
              break;

      }
      return  fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "Danh sách yêu thích ";
            case 1:
                return "Lịch sử";

        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}