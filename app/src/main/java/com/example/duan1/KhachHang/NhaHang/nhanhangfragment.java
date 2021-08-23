package com.example.duan1.KhachHang.NhaHang;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.duan1.MainActivity;
import com.example.duan1.R;

public class nhanhangfragment extends Fragment {
    int i = 0;
    Button huyDonhang, donHangThanhCong;
    TextView timeShip,status;
    ImageView next1, next2, next3, next4, ship1,back;
    Context context;
    FragmentManager fragmentManager;
    String maDh,locaiton,namenh,manh;
    public nhanhangfragment(Context context, FragmentManager fragmentManager,String maDh,String locaiton,String namenh,String manh) {
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.maDh = maDh;
        this.locaiton = locaiton;
        this.namenh = namenh;
        this.manh = manh;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.nhanhang, container, false);

        huyDonhang = view.findViewById(R.id.btnHuydonhang);
        donHangThanhCong = view.findViewById(R.id.btnDaNhanHang);

        status = view.findViewById(R.id.txtTrangthai);
        timeShip = view.findViewById(R.id.txtThoiGianShip);
        timeShip.setText(((MainActivity)context).TimeShip());

        next1= view.findViewById(R.id.imgnext1);
        next2 = view.findViewById(R.id.imgnext2);
        next3 = view.findViewById(R.id.imgnext3);
        next4 = view.findViewById(R.id.imgnext4);
        ship1 = view.findViewById(R.id.imgXe);

        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(i%2==0){
                    next1.setImageResource(R.drawable.next3);
                    next2.setImageResource(R.drawable.next3);
                    next3.setImageResource(R.drawable.giaoden);
                    next4.setImageResource(R.drawable.giaoden);
                    ship1.setImageResource(R.drawable.iiconship_2);
                }else {
                    next3.setImageResource(R.drawable.next3);
                    next4.setImageResource(R.drawable.next3);
                    next2.setImageResource(R.drawable.giaoden);
                    next1.setImageResource(R.drawable.giaoden);
                    ship1.setImageResource(R.drawable.supperfood);
                }
                i++;
                h.postDelayed(this,3000);
            }
        },3000);
        back =view.findViewById(R.id.imgback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,new ThanhToanDonHangFragment(locaiton,fragmentManager,context,namenh,manh)).commit();
            }
        });
        huyDonhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            status.setText("Đả Hủy");
            }
        });
        donHangThanhCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status.setText("Giao thành công");
            }
        });

        return view;


    }
}
