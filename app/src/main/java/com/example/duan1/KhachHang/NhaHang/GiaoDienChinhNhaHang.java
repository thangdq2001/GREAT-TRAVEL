package com.example.duan1.KhachHang.NhaHang;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Dao.MonAnDao;
import com.example.duan1.R;

public class GiaoDienChinhNhaHang extends Fragment {
    DanhSachMonAnAdapter adapter;
    String nameNhaHang,khoangCach,idNh;
    int thoiGianGiao,gioGiao;
    Double khoanCachSo;
    TextView nameNhaHangGd,thoiGian,kc,binhLuan;
    ImageView cart,back;
    int i =0;

    public GiaoDienChinhNhaHang(String nameNh, String idNhaHang, String location) {
        this.nameNhaHang = nameNh;
        this.idNh = idNhaHang;
        this.khoangCach = location;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.giaodien_chinh_nhahang, container, false);
        nameNhaHangGd = view.findViewById(R.id.txtNameNhaHangGiaoDien);
        kc = view.findViewById(R.id.txtKhoangCachGd);
        nameNhaHangGd.setText(nameNhaHang);
        kc.setText(khoangCach+"km");
        back = view.findViewById(R.id.imgbackFragment);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new NhaHangFragmentKhachHang()).commit();
            }
        });
        binhLuan = view.findViewById(R.id.txtChuyenFragmentBinhLuan);
        binhLuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new FragmentBinhLuanNhaHang(getContext(),getChildFragmentManager(),nameNhaHang,idNh,khoangCach)).commit();

            }
        });
        cart = view.findViewById(R.id.iconCart);
        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(i%2==0){
                    cart.setImageResource(R.drawable.cart);
                }else {
                    cart.setImageResource(R.drawable.cartcplus);

                }
                i++;
                h.postDelayed(this,5000);
            }
        },5000);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new ThanhToanDonHangFragment(khoangCach,getChildFragmentManager(),getContext(),nameNhaHang,idNh)).commit();
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recDanhSachMonAnNhaHangGiaoDien);
        adapter = new DanhSachMonAnAdapter(getContext(),getChildFragmentManager(),idNh);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        MonAnDao.SendDish(idNh,adapter,getContext());

        return view;
    }
//    public String timeGiao(){
//        khoanCachSo = Double.parseDouble(khoangCach);
//        if(khoanCachSo > 10.1){
//            thoiGianGiao = 1;
//
//        }
//    }


}
