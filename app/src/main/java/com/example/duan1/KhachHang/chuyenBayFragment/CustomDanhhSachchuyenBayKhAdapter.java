package com.example.duan1.KhachHang.chuyenBayFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Admin.Model.ChuyenBay;
import com.example.duan1.MainActivity;
import com.example.duan1.R;

import java.util.ArrayList;

public class CustomDanhhSachchuyenBayKhAdapter extends RecyclerView.Adapter<CustomDanhhSachchuyenBayKhAdapter.ViewHolder> {
    ArrayList<ChuyenBay> arrayList;

    FragmentManager fragmentManager;
    Context context;

    public CustomDanhhSachchuyenBayKhAdapter(FragmentManager fragmentManager, Context context) {
        arrayList = new ArrayList<>();
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_chuyenbay, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.showGiodi.setText(arrayList.get(position).getThoiGianBay());
        holder.showGioDen.setText(arrayList.get(position).getThoiGianDen());
        holder.thoiLuongBay.setText(arrayList.get(position).getThoiLuongBay());
        holder.maChuyenBay.setText(arrayList.get(position).getMaChuyenBay());
        holder.giaVe.setText(String.valueOf(arrayList.get(position).getGiaVe()));

        holder.btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThanhToanChuyenBay thanhToanChuyenBay = new ThanhToanChuyenBay(arrayList.get(position).getMaChuyenBay(),
                        arrayList.get(position).getThoiGianBay(),
                        arrayList.get(position).getThoiLuongBay(),
                        arrayList.get(position).getGiaVe(),
                        arrayList.get(position).getThue(),
                        arrayList.get(position).getPhi());


                ((MainActivity)context).changeFragmentKh(R.layout.layout_thanh_toan_chuyenbay,arrayList.get(position).getMaChuyenBay(),
                        arrayList.get(position).getThoiGianBay(),
                        arrayList.get(position).getThoiLuongBay(),
                        arrayList.get(position).getGiaVe(),
                        arrayList.get(position).getThue(),
                        arrayList.get(position).getPhi());





            }

        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView showGiodi, showGioDen, thoiLuongBay, maChuyenBay, giaVe;
        Button btnChon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            showGiodi = itemView.findViewById(R.id.txtShowGioBay);
            showGioDen = itemView.findViewById(R.id.txtShowGioDen);
            thoiLuongBay = itemView.findViewById(R.id.txtShowThoiLuongBay);
            maChuyenBay = itemView.findViewById(R.id.txtShowMaChuyenBay);
            giaVe = itemView.findViewById(R.id.txtShowGiaVe);
            btnChon = itemView.findViewById(R.id.btnChonChuyenBay);

        }
    }

    public void resetAdapterKhacHang() {
        arrayList.clear();
        notifyDataSetChanged();
    }

    public void updateAdapter(ChuyenBay chuyenBay) {
        arrayList.add(chuyenBay);
        notifyDataSetChanged();
    }

    public void Deletesuccess(int postion) {
        arrayList.remove(postion);
        notifyDataSetChanged();
    }

}
