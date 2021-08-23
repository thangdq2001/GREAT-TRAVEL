package com.example.duan1.Admin.Fragment.Dialog.KhachSan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Admin.AdminActivity;
import com.example.duan1.Admin.Fragment.Dialog.phongKhachSan.DialogaddPhongKhachSan;
import com.example.duan1.Admin.Model.KhachSan;
import com.example.duan1.Dao.KhachSanDao;
import com.example.duan1.R;

import java.util.ArrayList;

public class UpdateAndDeleteKhachSanAdapter extends RecyclerView.Adapter<UpdateAndDeleteKhachSanAdapter.ViewHolder> {
    Context context;
    FragmentManager fragmentManager;
    ArrayList<KhachSan> arrayList;

    public UpdateAndDeleteKhachSanAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
        arrayList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_updatedata_admin_khachsan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.nameKhachsan.setText(arrayList.get(position).getKsName());
        holder.idKhachSan.setText(arrayList.get(position).getKsId());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KhachSanDao.deleteKhachSan(arrayList.get(position).getKsId(), position, UpdateAndDeleteKhachSanAdapter.this);
            }
        });

//           open dialog update Khach san
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUpdateKhachSan dialogUpdateKhachSan = new DialogUpdateKhachSan(arrayList.get(position).getKsId());
                dialogUpdateKhachSan.show(fragmentManager, "DialogUpdateKhachSan");
            }
        });
        holder.addPhongKhachSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogaddPhongKhachSan dialogaddPhongKhachSan = new DialogaddPhongKhachSan(arrayList.get(position).getKsId());
                dialogaddPhongKhachSan.show(fragmentManager,"DialogaddPhongKhachSan");
            }
        });
        holder.xemChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AdminActivity)context).changeFragment(R.layout.danhsach_phong_khachsan_view);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameKhachsan, idKhachSan,xemChiTiet;
        ImageView delete, update,addPhongKhachSan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameKhachsan = itemView.findViewById(R.id.txtNameKhachSan_UpdateItem);
            delete = itemView.findViewById(R.id.imgDeleKhachSan);
            idKhachSan = itemView.findViewById(R.id.txtIdKhachSan_UpdateItem);
            update = itemView.findViewById(R.id.img_item_update_khachsan);
            addPhongKhachSan = itemView.findViewById(R.id.imgAddPhongKhachSan);
            xemChiTiet = itemView.findViewById(R.id.txtTileXemChiTietKhachSan);
        }
    }

    public void updateAdapter(KhachSan khachSan) {
        arrayList.add(khachSan);
        notifyDataSetChanged();
    }

    public void resetAdapter(){
        arrayList.clear();
        notifyDataSetChanged();
    }
    public void onDeleteSuccessful(int position) {
        arrayList.remove(position);
        notifyDataSetChanged();
    }
}
