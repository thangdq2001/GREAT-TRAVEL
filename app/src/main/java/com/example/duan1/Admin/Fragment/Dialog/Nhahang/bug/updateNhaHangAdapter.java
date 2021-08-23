//package com.example.duan1.Admin.Fragment.Dialog.Nhahang;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.duan1.Admin.Model.NhaHang;
//import com.example.duan1.R;
//
//import java.util.ArrayList;
//
//public class updateNhaHangAdapter extends RecyclerView.Adapter<updateNhaHangAdapter.viewHolder> {
//  ArrayList<NhaHang> arrayList;
//
//
//    public updateNhaHangAdapter(ArrayList<NhaHang> arrayList, Context context) {
//        this.arrayList = arrayList;
//
//    }
//
//    @NonNull
//    @Override
//    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_updatedata_admin_nhahang, null);
//        return new viewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
//        holder.txtNameNhahang.setText(arrayList.get(position).getNhName());
//    }
//
//    @Override
//    public int getItemCount() {
//        return arrayList.size();
//    }
//
//    public class viewHolder extends RecyclerView.ViewHolder {
//        TextView txtNameNhahang;
//        ImageView buttonUpdateNhahang;
//        public viewHolder(@NonNull View itemView) {
//            super(itemView);
//            txtNameNhahang = itemView.findViewById(R.id.txtNameNhaHang_UpdateItem);
//            buttonUpdateNhahang = itemView.findViewById(R.id.img_item_update_nhahang);
//        }
//    }
//}
