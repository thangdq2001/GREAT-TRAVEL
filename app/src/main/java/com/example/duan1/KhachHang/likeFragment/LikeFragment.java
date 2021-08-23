package com.example.duan1.KhachHang.likeFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.duan1.R;
import com.example.duan1.adapter_tab.SectionsPagerAdapter1;
import com.google.android.material.tabs.TabLayout;

public class LikeFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenth_like, container, false);
        ViewPager viewPager = view.findViewById(R.id.view_pager1);
        SectionsPagerAdapter1 adapter = new SectionsPagerAdapter1(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = view.findViewById(R.id.tabs1);
        tabLayout.setupWithViewPager(viewPager);
        // custom


        return view;
    }


}
