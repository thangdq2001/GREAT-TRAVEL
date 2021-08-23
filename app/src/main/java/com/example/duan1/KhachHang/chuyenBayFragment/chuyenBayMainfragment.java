package com.example.duan1.KhachHang.chuyenBayFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.duan1.KhachHang.HomeFragMent;
import com.example.duan1.R;
import com.example.duan1.adapter_tab.tabchuyenbayMainAdapter;
import com.google.android.material.tabs.TabLayout;

public class chuyenBayMainfragment extends Fragment {
ImageView imgViewBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chuyenbay_main, container, false);
        ViewPager viewPager = view.findViewById(R.id.view_pagrchuyenbay);
        tabchuyenbayMainAdapter adapter = new tabchuyenbayMainAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = view.findViewById(R.id.tabChuyenBayMain);
        tabLayout.setupWithViewPager(viewPager);

        // custom back
        imgViewBack = view.findViewById(R.id.iconBack);
        customButtonBack();


        return view;
    }
    public void customButtonBack(){
        imgViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,new HomeFragMent()).commit();
            }
        });
    }


}
