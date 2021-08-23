package com.example.duan1.KhachHang.KhachSan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Admin.Model.KhachSanPhong;
import com.example.duan1.R;

import java.util.ArrayList;

public class DanhSachPhongAdapter extends RecyclerView.Adapter<DanhSachPhongAdapter.ViewHolder> {
    ArrayList<KhachSanPhong> arrayList;
    FragmentManager fragmentManager;
    Context context;

    public DanhSachPhongAdapter(FragmentManager fragmentManager, Context context) {
        arrayList = new ArrayList<>();
        this.fragmentManager = fragmentManager;
        this.context = context;
    }

    @NonNull
    @Override
    public DanhSachPhongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.danhsachphongks_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhSachPhongAdapter.ViewHolder holder, int position) {
        holder.loaiPhong.setText(arrayList.get(position).getKsPLoai());
        holder.giaPhong.setText(String.valueOf(arrayList.get(position).getKsPGiaPhong()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView loaiPhong, giaPhong;
        Button chonPhong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            loaiPhong = itemView.findViewById(R.id.txtLoaiPhong);
            giaPhong = itemView.findViewById(R.id.txtGiaPhong);
            chonPhong = itemView.findViewById(R.id.btnchonphong);
        }
    }
    public void  updateAdapter(KhachSanPhong item){
        arrayList.add(item);
        notifyDataSetChanged();
    }
    public void resetAdapter(){
        arrayList.clear();
        notifyDataSetChanged();
    }
}
