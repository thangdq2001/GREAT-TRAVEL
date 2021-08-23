package com.example.duan1.KhachHang.likeFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.R;

public class yeuthichFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_yeuthich_fragment, container, false);
        RecyclerView   mRecyclerView = view.findViewById(R.id.recLike);




        return view;
    }

//    public void customRecyerView() {
//        nameDN = new ArrayList<>();
//        locationDN = new ArrayList<>();
//        danhGiaDN = new ArrayList<>();
//        quangCaoDN = new ArrayList<>();
//        img = new ArrayList<>();
//        // add data to list nameDN
//        nameDN.add("Khách Sạn Hồng Quang");
//        nameDN.add("Khách Sạn Thanh Xuân");
//        nameDN.add("Khách Sạn Chiến Thắng");
//        nameDN.add("Khách Sạn Sài Gòn");
//        nameDN.add("Khách Sạn Container");
//        nameDN.add("Khách Sạn Điện Biên Phủ");
//
//        //add data to list locaiton
//        locationDN.add("700 Vĩnh Viễn");
//        locationDN.add("350 Lý Chính Thắng");
//        locationDN.add("210 Nam Kì Khởi Nghĩa");
//        locationDN.add("102 CMT8");
//        locationDN.add("430 Võ Văn Tần");
//        locationDN.add("219 Điện Biên Phủ");
//
//
//        // add data to list danhGia
//        danhGiaDN.add("5 sao");
//        danhGiaDN.add("4,5 Sao");
//        danhGiaDN.add("4 sao");
//        danhGiaDN.add("4,5 Sao");
//        danhGiaDN.add("4 sao");
//        danhGiaDN.add("4,5 Sao");
//
//        // add data to list quangCao
//
//        quangCaoDN.add("Khách sạn đáng được yếu thích");
//        quangCaoDN.add("Khách sạn mang đến sự tiện lợi và phồn vinh");
//        quangCaoDN.add("Khách sạn mang đến chất lượng tốt nhất");
//        quangCaoDN.add("Khách sạn mang đến những giấc ngủ tốt nhất");
//        quangCaoDN.add("Nơi bạn nên đến cho các kì nghỉ");
//        quangCaoDN.add("Chất lượng hàng đầu");
//
//        // add ta to list img
//
//        img.add(R.drawable.iconfind);
//        img.add(R.drawable.iconfind);
//        img.add(R.drawable.iconfind);
//        img.add(R.drawable.iconfind);
//        img.add(R.drawable.iconfind);
//        img.add(R.drawable.iconfind);
//
////        adapter = new liekMainAdapter(getActivity(),nameDN,locationDN,danhGiaDN,quangCaoDN,img);
////       Context context;
////        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
////        recyclerView.setLayoutManager(manager);
////        recyclerView.setAdapter(adapter);
//        mManager= new LinearLayoutManager(getActivity());
//        madapter= new liekMainAdapter(getActivity(),nameDN,locationDN,danhGiaDN,quangCaoDN,img);
//        mRecyclerView.setLayoutManager(mManager);
//        mRecyclerView.setAdapter(madapter);
//
//    }
}
