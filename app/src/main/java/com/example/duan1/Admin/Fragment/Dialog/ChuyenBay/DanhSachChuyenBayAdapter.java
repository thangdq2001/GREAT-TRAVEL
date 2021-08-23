package com.example.duan1.Admin.Fragment.Dialog.ChuyenBay;

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

import com.example.duan1.Admin.Model.ChuyenBay;
import com.example.duan1.Dao.ChuyenBayDao;
import com.example.duan1.R;

import java.util.ArrayList;

public class DanhSachChuyenBayAdapter extends RecyclerView.Adapter<DanhSachChuyenBayAdapter.ViewHolder> {
    ArrayList<ChuyenBay> arrayList;
    Context context;
    FragmentManager fragmentManager;

    public DanhSachChuyenBayAdapter(Context context,FragmentManager fragmentManager) {
        arrayList = new ArrayList<>();
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_suaxoachuyenbay, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.maChuyenBay.setText(arrayList.get(position).getMaChuyenBay());
        holder.gioBay.setText(arrayList.get(position).getThoiGianDen());
        holder.gioDen.setText(arrayList.get(position).getThoiGianDen());
        holder.thoiLuongBay.setText(arrayList.get(position).getThoiLuongBay());
        holder.giaVe.setText(String.valueOf(arrayList.get(position).getGiaVe()));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChuyenBayDao.chuyenBayDelete(arrayList.get(position).getIdChuyenbay(),position,DanhSachChuyenBayAdapter.this);
            }
        });
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUpdateChuyenBay  dialogUpdateChuyenBay = new DialogUpdateChuyenBay(arrayList.get(position).getIdChuyenbay());
                dialogUpdateChuyenBay.show(fragmentManager,"DialogUpdateChuyenBay");
                Toast.makeText(context, "Dialog Update", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
TextView maChuyenBay,gioBay,gioDen,thoiLuongBay,giaVe;
ImageView delete,update;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            maChuyenBay = itemView.findViewById(R.id.txtShowMaChuyenBay);
            gioBay = itemView.findViewById(R.id.txtShowGioBay);
            gioDen = itemView.findViewById(R.id.txtShowGioDen);
            thoiLuongBay = itemView.findViewById(R.id.txtShowThoiLuongBay);
            giaVe = itemView.findViewById(R.id.txtShowGiaVe);
            delete = itemView.findViewById(R.id.imgDeleteChuyenBay);
            update = itemView.findViewById(R.id.imgUpdateDataDialogChuyenBay);

        }
    }

    public void updateAdapter(ChuyenBay chuyenBay) {
        arrayList.add(chuyenBay);
        notifyDataSetChanged();

    }

    public void deleteSuccess(int position) {
        arrayList.remove(position);
        notifyDataSetChanged();
    }

    public void resetAdapterChuyenBay() {
        arrayList.clear();
        notifyDataSetChanged();
    }

}
