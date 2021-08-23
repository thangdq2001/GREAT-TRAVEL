package com.example.duan1.adapter_tab;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.duan1.KhachHang.chuyenBayFragment.chuyenbay1chiueFragment;
import com.example.duan1.KhachHang.chuyenBayFragment.danhsachchuyenbayFragmentKH;
import com.example.duan1.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class tabchuyenbayMainAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.chuyenbaytab1,R.string.chuyenbaytab2};
    // thông số thay đổi



    public tabchuyenbayMainAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
      FragmentPagerAdapter fragmentPagerAdapter1;
      Fragment fragment = null;
      switch (position){
          case  0:
              fragment = new chuyenbay1chiueFragment();
                    break;
          case  1:
              fragment = new danhsachchuyenbayFragmentKH();
              break;

      }
      return  fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "Một chiều";
            case 1:
                return "Danh sách chuyến bay";

        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}