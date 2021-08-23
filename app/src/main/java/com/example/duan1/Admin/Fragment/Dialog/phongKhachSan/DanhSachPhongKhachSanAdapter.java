package com.example.duan1.Admin.Fragment.Dialog.phongKhachSan;

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

import com.example.duan1.Admin.Model.KhachSanPhong;
import com.example.duan1.Dao.KhachSanPhongDao;
import com.example.duan1.R;

import java.util.ArrayList;

public class DanhSachPhongKhachSanAdapter extends RecyclerView.Adapter<DanhSachPhongKhachSanAdapter.ViewHolder> {
    ArrayList<KhachSanPhong> arrayList;
    Context context;

    FragmentManager fragmentManager;

    public DanhSachPhongKhachSanAdapter(Context context, FragmentManager fragmentManager) {
        this.context = context;
        arrayList = new ArrayList<>();
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_item_danhsachphong_khachsan, null);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
    holder.delete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            KhachSanPhongDao.deletePhong(arrayList.get(position).getKspId(),position, DanhSachPhongKhachSanAdapter.this);
            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
        }
    });
    holder.update.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DialogUpdatePhong dialogUpdatePhong = new DialogUpdatePhong(arrayList.get(position).getKspId(),arrayList.get(position).getIdKhachSan());
            dialogUpdatePhong.show(fragmentManager,"DialogUpdatePhong");
            Toast.makeText(context, "Dialog Update", Toast.LENGTH_SHORT).show();
        }
    });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView update,delete;
        TextView nameKhachSan,soLuongPhong;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            update = itemView.findViewById(R.id.imgUpdatePhongKhachSan);
            delete = itemView.findViewById(R.id.imgDeletePhongKhachSan);
            nameKhachSan = itemView.findViewById(R.id.txtNamePhongKhachSan);
            soLuongPhong = itemView.findViewById(R.id.txtSoLuongPhong);
        }
    }
    public void updateAdapter(KhachSanPhong khachSanPhong) {
        arrayList.add(khachSanPhong);
        notifyDataSetChanged();
    }
    public void onDeleteSuccessful(int postiton){
        arrayList.remove(postiton);
        notifyDataSetChanged();
    }
    public void resetAdapter() {
        arrayList.clear();
        notifyDataSetChanged();
    }

}
