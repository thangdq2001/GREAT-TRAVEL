package com.example.duan1.KhachHang;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.KhachHang.KhachSan.DanhSachKhachSanFragment;
import com.example.duan1.KhachHang.NhaHang.NhaHangFragmentKhachHang;
import com.example.duan1.KhachHang.chuyenBayFragment.chuyenBayMainfragment;
import com.example.duan1.R;
import com.example.duan1.aDapter.GridViewBottomMainAdapter;

import java.util.List;

public class HomeFragMent extends Fragment {
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    List<String> titles;
    List<String> location;
    List<Integer> img;
    GridViewBottomMainAdapter adapter;
    CardView hotel, flight, food, hoatdong, oderCar, shopping;
    ImageView imgOpenFood,nhud1,nhud2,ksud1,ksud2,cbud1,cbud2;
    int i =0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);
        viewFlipper = view.findViewById(R.id.slideShow);
        int imges[] = {R.drawable.slideshow1, R.drawable.slidehow2, R.drawable.slideshow3};
        for (int image : imges) {
            customSlideShow(image);
        }

        // customsGridlayoutbottom Main
//        customGridLayoutBottom();

        //opencardView-->Chuyến bay
        flight = view.findViewById(R.id.cardViewChuyenBay);
        openCardViewFlight();
        food = view.findViewById(R.id.cardViewFood);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new NhaHangFragmentKhachHang()).commit();
                Toast.makeText(getContext(), "Open Food", Toast.LENGTH_SHORT).show();
            }
        });
        imgOpenFood = view.findViewById(R.id.imgOpenFood);
        imgOpenFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new NhaHangFragmentKhachHang()).commit();
                Toast.makeText(getContext(), "Open Food", Toast.LENGTH_SHORT).show();
            }
        });
        hotel = view.findViewById(R.id.cardViewKhachSan);
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,new DanhSachKhachSanFragment()).commit();
            }
        });

        nhud1 = view.findViewById(R.id.imgUudainh1);
        nhud2 = view.findViewById(R.id.imgUudainh2);
        ksud1 = view.findViewById(R.id.imgKsUd1);
        ksud2 = view.findViewById(R.id.imgKsUd2);
        cbud1 = view.findViewById(R.id.imgCbUd1);
        cbud2 = view.findViewById(R.id.imgCbud2);
        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(i%2==0){
                    nhud1.setImageResource(R.drawable.trungn);
                    nhud2.setImageResource(R.drawable.higland2);
                    ksud1.setImageResource(R.drawable.kingshotel2);
                    ksud2.setImageResource(R.drawable.muonthanh2);
                    cbud1.setImageResource(R.drawable.bambo2);
                    cbud2.setImageResource(R.drawable.vietjet2);
                }else {
                    nhud1.setImageResource(R.drawable.trungnguyen3);
                    nhud2.setImageResource(R.drawable.higland3);
                    ksud1.setImageResource(R.drawable.kingsholthel3);
                    ksud2.setImageResource(R.drawable.muonthanh3);
                    cbud1.setImageResource(R.drawable.bambo3);
                    cbud2.setImageResource(R.drawable.vietjet3);
                }
                i++;
                h.postDelayed(this,5000);

            }
        },5000);




        return view;
    }

    public void openCardViewFlight() {
        flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new chuyenBayMainfragment()).commit();
            }
        });
    }

//    public void customGridLayoutBottom() {
//        titles = new ArrayList<>();
//        img = new ArrayList<>();
//        location = new ArrayList<>();
//
//        // add data to arraylist titles
//        titles.add("Khach san 1 phuc vu 24/24 chat luong 5s");
//        titles.add("Khach san 2 chất lượng có máy lạnh than máy nằm ngay mặt tiền đường lê hồng phong");
//        titles.add("Khach san 3 phòng đầy đủ tiện nghi nằm ngay mặt tiền điền trần hưng đạo");
//        titles.add("Khach san 4 phục vụ 24/24 đầy đủ tiện nghi thoáng mát sạch sẽ");
//
//        // add data to arraylist img
//        img.add(R.drawable.logo1);
//        img.add(R.drawable.logo2);
//        img.add(R.drawable.logo2);
//        img.add(R.drawable.logo2);
//
//
//
//
//        img.add(R.drawable.logo4);
//        // add data arraylist locaiton
//
//        location.add("cách vị trí hiện tại 500m");
//        location.add("cách vị trí hiện tại 1km");
//        location.add("cách vị trí hiện tại 1,5km");
//        location.add("cách vị trí hiện tại 100m");
//
//        adapter = new GridViewBottomMainAdapter(getActivity(), titles, location, img);
//        Context context;
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerView.setAdapter(adapter);
//
//
//    }

    public void customSlideShow(int image) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);//--> slide show auto play in 4s
        viewFlipper.setAutoStart(true);
        // animation
        viewFlipper.setInAnimation(getContext(), R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getActivity(), R.anim.slide_out_right);
    }
}
