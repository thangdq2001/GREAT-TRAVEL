package com.example.duan1.Admin;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.duan1.Admin.Fragment.AdminCarFragment;
import com.example.duan1.Admin.Fragment.Dialog.ChuyenBay.AdminChuyenBayFragment;
import com.example.duan1.Admin.Fragment.Dialog.KhachSan.AdminKhachSanFragment;
import com.example.duan1.Admin.Fragment.Dialog.MonAn.UpdateAndDeleteMonAn;
import com.example.duan1.Admin.Fragment.Dialog.Nhahang.AdminNhaHangFragment;
import com.example.duan1.Admin.Fragment.AdminShoppingFragment;
import com.example.duan1.Admin.Fragment.Dialog.phongKhachSan.DanhSachPhongKhachSan;
import com.example.duan1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdminActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        // custom bottomNavigationView ;
        customBottom();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainerAdmin, new AdminNhaHangFragment()).commit();
    }

    public void customBottom() {
        bottomNavigationView = findViewById(R.id.bottomAdmin);
        final Menu menu = bottomNavigationView.getMenu();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.botNhahan:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainerAdmin, new AdminNhaHangFragment()).commit();
                        item = menu.findItem(R.id.botNhahan).setChecked(true);
                        break;
                    case R.id.botKhacSan:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainerAdmin, new AdminKhachSanFragment()).commit();
                        item = menu.findItem(R.id.botKhacSan).setChecked(true);
                        break;
                    case R.id.botChuyenBay:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainerAdmin, new AdminChuyenBayFragment()).commit();
                        item = menu.findItem(R.id.botChuyenBay).setChecked(true);
                        break;
                    case R.id.botShopping:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainerAdmin, new AdminShoppingFragment()).commit();
                        item = menu.findItem(R.id.botShopping).setChecked(true);
                        break;
                    case R.id.botXe:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainerAdmin, new AdminCarFragment()).commit();
                        item = menu.findItem(R.id.botXe).setChecked(true);
                        break;
                }
                return  false;
            }
        });

    }
    public  void changeFragment(int id){
       switch (id){
           case R.layout.danhsachmonan_update_and_delete:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainerAdmin, new UpdateAndDeleteMonAn()).commit();
               break;
           case R.layout.danhsach_phong_khachsan_view:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainerAdmin ,new DanhSachPhongKhachSan()).commit();
               break;

       }
    }
}