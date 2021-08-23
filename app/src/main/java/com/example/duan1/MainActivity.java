package com.example.duan1;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.duan1.Dao.NhaHangDao;
import com.example.duan1.KhachHang.HomeFragMent;
import com.example.duan1.KhachHang.KhachSan.DanhSachPhong;
import com.example.duan1.KhachHang.NhaHang.GiaoDienChinhNhaHang;
import com.example.duan1.KhachHang.TravrelFragment;
import com.example.duan1.KhachHang.chuyenBayFragment.ThanhToanChuyenBay;
import com.example.duan1.KhachHang.likeFragment.LikeFragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private Location location;
    private GoogleApiClient gac;
    Button btnAdd;
    BottomNavigationView bottomNavigationView;
    Fragment fragment = null;
    String username,tenNguoiDung,diaChi,sdt,mail;
    Integer timeShip = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customBottom();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new HomeFragMent()).commit();
        if (checkPlayServices()) {
            // Building the GoogleApi client
            buildGoogleApiClient();
        }
        Bundle b = getIntent().getBundleExtra("UserInfo");
        username = b.getString("username");
        tenNguoiDung = b.getString("name");
        diaChi = b.getString("diachi");
        sdt  = b.getString("sdt");
        mail = b.getString("mail");

    }

    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this, 1000).show();
            } else {
                Toast.makeText(this, "Thiết bị này không hỗ trợ.", Toast.LENGTH_LONG).show();
                finish();
            }
            return false;
        }
        return true;
    }

    // locaiton
    public String getLocation(Double lat, Double lon) {
        String KhoangCach = "";
        Double khoanCach = 0.0;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Kiểm tra quyền hạn
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 2);


        } else {
            location = LocationServices.FusedLocationApi.getLastLocation(gac);
            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                // Hiển thị
                Double varKc = NhaHangDao.TinhKhoangCachNhaHang(latitude, longitude, lat, lon);
                khoanCach = varKc;
                Toast.makeText(this, String.valueOf(khoanCach), Toast.LENGTH_SHORT).show();
                Log.d("toat", String.valueOf(khoanCach));
                KhoangCach = String.valueOf(khoanCach).substring(0, 2);
                return KhoangCach;

            } else {
                Toast.makeText(this, "hông thể hiển thị vị trí.Bạn đã kích hoạt location trên thiết bị chưa?)", Toast.LENGTH_SHORT).show();

            }

        }

        return KhoangCach;

    }


    // custom bottom navigation
    public void customBottom() {

        bottomNavigationView = findViewById(R.id.bottomMain);
        final Menu menu = bottomNavigationView.getMenu();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menuHome:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new HomeFragMent()).commit();
                        item = menu.findItem(R.id.menuHome).setChecked(true);
                        break;
                    case R.id.menuLike:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new LikeFragment()).commit();
                        item = menu.findItem(R.id.menuLike).setChecked(true);
                        break;
                    case R.id.menuTravel:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new TravrelFragment()).commit();
                        item = menu.findItem(R.id.menuTravel).setChecked(true);
                        break;
                }
                return false;
            }
        });
    }

    public void changeFragmentKh(int id, String MaCb, String TimeBay, String TimeDen, Double Price, Double Vat, Double Phi) {
        switch (id) {
            case R.layout.layout_thanh_toan_chuyenbay:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new ThanhToanChuyenBay(MaCb, TimeBay, TimeDen, Price, Vat, Phi
                )).commit();
                break;
        }
    }

    public void changeFragmet2(int idLayout, String nameNh, String idNh, String locaiton) {
        switch (idLayout) {
            case R.layout.giaodien_chinh_nhahang:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new GiaoDienChinhNhaHang(nameNh, idNh, locaiton)).commit();
                break;
        }
    }
    public void changeFragment4(int id, String idKs, Context context){
        switch (id){
            case R.layout.danhsachphong_fragment:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new DanhSachPhong(getSupportFragmentManager(),context,idKs)).commit();
        }
    }

    public void changeFragment3(int idLayout, String nameNh, String idNh, String locaiton) {
        switch (idLayout) {
            case R.layout.giaodien_chinh_nhahang:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new GiaoDienChinhNhaHang(nameNh, idNh, locaiton)).commit();
                break;
        }
    }

    protected synchronized void buildGoogleApiClient() {
        if (gac == null) {
            gac = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API).build();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }


    @Override
    public void onConnectionSuspended(int i) {
        gac.connect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, "Lỗi kết nối: " + connectionResult.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    protected void onStart() {
        gac.connect();
        super.onStart();
    }

    protected void onStop() {
        gac.disconnect();
        super.onStop();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String TimeNow() {
        DateFormat dateFormat = new SimpleDateFormat("dd,MM,yyyy, HH.mm");
        String date = dateFormat.format(Calendar.getInstance().getTime());
        return date;

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String TimeShip() {
        DateFormat dateFormat = new SimpleDateFormat("HH");
        DateFormat dateFormat1 = new SimpleDateFormat("mm");
        int gio = Integer.parseInt(dateFormat.format(Calendar.getInstance().getTime()));
        int phut = Integer.parseInt(dateFormat1.format(Calendar.getInstance().getTime()));
        int time =30;
        if(phut>30){
            gio = gio+1;
            phut = (time + phut)-60;

        }else {
            gio = gio *1;
            phut =phut+30;
        }
        String timeShip = String.valueOf(gio) + "h:"+String.valueOf(phut)+"'";
        return timeShip;

    }

    public String getUsername() {
        String tk = username;
        return tk;
    }
//    public String getNameNd(){
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("User");
//        databaseReference.orderByChild("username").equalTo(String.valueOf(getUsername())).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        })
//
//    }
public String getTenNguoiDung(){
        String ten = tenNguoiDung;
        return  ten;
}
public String getDiaChi(){
        String locatioon = diaChi;
        return  locatioon;
}

}