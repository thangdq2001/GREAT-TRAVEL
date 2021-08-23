package com.example.duan1.KhachHang.NhaHang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Admin.Model.VoHang;
import com.example.duan1.Dao.CartDao;
import com.example.duan1.R;

import java.util.ArrayList;

public class VoHangAdapter extends RecyclerView.Adapter<VoHangAdapter.ViewHolder> {
    ArrayList<VoHang> arrayList;
    FragmentManager fragmentManager;
    Context context;
    double TongTien =0,soLuong = 0;
    TextView tongTien;
    String idNh,nameNh,locaiton;

    public VoHangAdapter(FragmentManager fragmentManager, Context context,TextView tongTien,String idNh,String nameNh,String locaiton) {
        arrayList = new ArrayList<>();
        this.fragmentManager = fragmentManager;
        this.context = context;
        this.tongTien = tongTien;
        this.idNh = idNh;
        this.nameNh = nameNh;
        this.locaiton = locaiton;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_chitietmonan, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tenMonAn.setText(arrayList.get(position).getTenMon());
        holder.SoLuong.setText(String.valueOf(arrayList.get(position).getSoLuong())+"x");
        holder.thanhTien.setText(String.valueOf(arrayList.get(position).getThanhTien()));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartDao.delete(arrayList.get(position).getIdVoHang(),position,VoHangAdapter.this);
                Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
                Double tien = Double.parseDouble(tongTien.getText().toString());
                tongTien.setText(String.valueOf(truTien(position,tien)));




            }
        });
        holder.note.setText(arrayList.get(position).getGhiChi());




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView delete, tang, giam;
        TextView tenMonAn, thanhTien, SoLuong,note;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tenMonAn = itemView.findViewById(R.id.txtTenMonDat);
            thanhTien = itemView.findViewById(R.id.txtThanhtienMon);
            SoLuong = itemView.findViewById(R.id.txtSoLuongMonDat);
            delete = itemView.findViewById(R.id.imgDelete);
            note = itemView.findViewById(R.id.txtShowGhiChu);
        }
    }

    public void updateAdapter(VoHang voHang) {
        arrayList.add(voHang);
        notifyDataSetChanged();
    }

    public void resetAdapter() {
        arrayList.clear();
        notifyDataSetChanged();
    }
    public void deletesuccess(int position){
         arrayList.remove(position);
         notifyDataSetChanged();
    }
    public double getTongTien(){
        for(VoHang i:arrayList){
            TongTien = TongTien + i.getThanhTien();

        }
        return TongTien;
    }
    public double getTongMon(){
        for (VoHang i:arrayList){
            soLuong = soLuong +i.getSoLuong();
        }
        return  soLuong;
    }
    public double truTien(int position,Double tien){
        for (VoHang i:arrayList){
            TongTien = tien - arrayList.get(position).getThanhTien();
        }
        return TongTien;
    }
}
