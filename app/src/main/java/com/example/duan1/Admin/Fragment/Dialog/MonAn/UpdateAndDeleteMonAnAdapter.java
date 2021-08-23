package com.example.duan1.Admin.Fragment.Dialog.MonAn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1.Admin.Model.MonAn;
import com.example.duan1.Dao.MonAnDao;
import com.example.duan1.R;

import java.util.ArrayList;

public class UpdateAndDeleteMonAnAdapter extends RecyclerView.Adapter<UpdateAndDeleteMonAnAdapter.ViewHolder> {
    public UpdateAndDeleteMonAnAdapter(FragmentManager fragmentManager) {
        arrayList = new ArrayList<>();
        this.fragmentManager = fragmentManager;
    }
    FragmentManager fragmentManager;
    ArrayList<MonAn> arrayList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_delete_and_update_monan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            holder.nameMonAn.setText(arrayList.get(position).getNhMaName());
            holder.idMonAn.setText(arrayList.get(position).getNhMaId());
            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MonAnDao.delteteMonAn(arrayList.get(position).getNhMaId(),position  ,UpdateAndDeleteMonAnAdapter.this);
                }
            });
            holder.update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogUpdateMonAn dialogUpdateMonAn = new DialogUpdateMonAn(arrayList.get(position).getNhMaId(),arrayList.get(position).getNhMaIdNhaHang());
                    dialogUpdateMonAn.show(fragmentManager,"DialogUpdateMonAn");
                }
            });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameMonAn,idMonAn;
        ImageView delete,update;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameMonAn = itemView.findViewById(R.id.txtNameUpdateNameMonAn);
            delete = itemView.findViewById(R.id.imgDeleteMonAn);
            idMonAn = itemView.findViewById(R.id.txtIdUpdateMonAn);
            update = itemView.findViewById(R.id.imgUpdateMonAn);
        }
    }
    public void resetAdpter(){
        arrayList.clear();
        notifyDataSetChanged();
    }
    public void updateAdapter(MonAn monAn) {
        arrayList.add(monAn);
        notifyDataSetChanged();
    }
    public void onDeleteSuccessful(int position){
        arrayList.remove(position);
        notifyDataSetChanged();
    }
}
