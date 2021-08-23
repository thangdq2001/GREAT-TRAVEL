//package com.example.duan1;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.duan1.Admin.Model.NhaHang;
//
//import java.util.ArrayList;
//
//public class testAdapter extends RecyclerView.Adapter<testAdapter.viewHolder>{
//ArrayList<NhaHang> Nh ;
//Context context;
//
//    public testAdapter(ArrayList<NhaHang> nh, Context context) {
//        Nh = nh;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customtestreadall, parent, false);
//        return new viewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull testAdapter.viewHolder holder, int position) {
//
//        holder.test1.setText(Nh.get(position).getNhId());
//        holder.test2.setText(Nh.get(position).getNhName());
//        holder.test3.setText(Nh.get(position).getNhNhomNhaHang());
////        Toast.makeText(context,Nh.get(position).getNhId() ,Toast.LENGTH_LONG).show();
////        Toast.makeText(context,Nh.get(position).getNhName() ,Toast.LENGTH_LONG).show();
////        Toast.makeText(context,Nh.get(position).getNhNhomNhaHang() ,Toast.LENGTH_SHORT).show();
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return Nh.size();
//    }
//
//    public class viewHolder extends RecyclerView.ViewHolder {
//        TextView test1,test2,test3;
//        public viewHolder(@NonNull View itemView) {
//            super(itemView);
//            test1 = itemView.findViewById(R.id.txtTest1);
//            test2 = itemView.findViewById(R.id.txtTest2);
//            test3 = itemView.findViewById(R.id.txtTest3);
//
//        }
//    }
//}
