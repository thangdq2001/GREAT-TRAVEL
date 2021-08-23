package com.example.duan1.Admin.Fragment.Dialog.Nhahang;

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

import com.example.duan1.Admin.AdminActivity;
import com.example.duan1.Admin.Fragment.Dialog.MonAn.DialogaddMonAn;
import com.example.duan1.Admin.Model.NhaHang;
import com.example.duan1.Dao.NhaHangDao;
import com.example.duan1.R;

import java.util.ArrayList;

public class UpdateAndDeleteNhaHangAdapter extends RecyclerView.Adapter<UpdateAndDeleteNhaHangAdapter.ViewHolder> {
    Context context;

    public UpdateAndDeleteNhaHangAdapter(FragmentManager fragmentManager,Context context) {
        arrayList = new ArrayList<>();
        this.fragmentManager = fragmentManager;
        this.context = context;
    }
    FragmentManager fragmentManager;
    ArrayList<NhaHang> arrayList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_delete_and_update_admin_nhahang, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.nameNhaHang.setText(arrayList.get(position).getNhName());
        holder.idNhaHang.setText("Thêm món ăn click để xem món ăn");
        holder.idNhaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AdminActivity)context).changeFragment(R.layout.danhsachmonan_update_and_delete);
            }
        });
           holder.delete.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   NhaHangDao.deleteNhahang(arrayList.get(position).getNhId(), position, UpdateAndDeleteNhaHangAdapter.this);
               }
           });
           holder.update.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Toast.makeText(context, "Thay đổi thông tin", Toast.LENGTH_SHORT).show();
                   DialogUpdateNhaHang dialogUpdateNhaHang = new DialogUpdateNhaHang(arrayList.get(position).getNhId());
                   dialogUpdateNhaHang.show(fragmentManager,"DialogUpdateNhaHang");
               }
           });
        holder.addMonAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Nhập món ăn", Toast.LENGTH_SHORT).show();
                DialogaddMonAn dialogaddMonAn = new DialogaddMonAn(arrayList.get(position).getNhId());
                dialogaddMonAn.show(fragmentManager,"DialogaddMonAn");
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameNhaHang,idNhaHang;
        ImageView delete,addMonAn,update;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameNhaHang = itemView.findViewById(R.id.txtNameNhaHangUpdateAndDelete);
            delete = itemView.findViewById(R.id.img_item_delete_nhahang);
            idNhaHang = itemView.findViewById(R.id.txtIdNhaHAng_update_and_delete);
            addMonAn = itemView.findViewById(R.id.imgAddMonAn);
            update = itemView.findViewById(R.id.img_item_update_nhaHang);
        }
    }
    public void resetAdapter() {
        arrayList.clear();
        notifyDataSetChanged();
    }

    public void updateAdapter(NhaHang nhaHang) {
        arrayList.add(nhaHang);
        notifyDataSetChanged();
    }
    public void onDeleteSuccessful(int position){
        arrayList.remove(position);
        notifyDataSetChanged();
    }
}
