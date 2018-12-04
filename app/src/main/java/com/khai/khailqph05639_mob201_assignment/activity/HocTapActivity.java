package com.khai.khailqph05639_mob201_assignment.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.khai.khailqph05639_mob201_assignment.R;
import com.khai.khailqph05639_mob201_assignment.fragment.CourseFragment;
import com.khai.khailqph05639_mob201_assignment.fragment.DangKyFragment;
import com.khai.khailqph05639_mob201_assignment.fragment.LichHocFragment;
import com.khai.khailqph05639_mob201_assignment.fragment.LichThiFragment;


public class HocTapActivity extends AppCompatActivity {

    public String name1;

    public String sdt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_hoc_tap );

        BottomNavigationView bottomNavigationView = findViewById (R.id.btNavigation);

        BottomNavigationViewHelper.removeShiftMode (bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.Course);
        Fragment fragment = null;
        fragment = new CourseFragment();
        FragmentManager fragmentManager = getFragmentManager ();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
        fragmentTransaction.replace (R.id.frameLayout, fragment);
        fragmentTransaction.commit ();


        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment= null;

                if (item.getItemId () == R.id.Course) {

                    fragment = new CourseFragment ();
                    FragmentManager fragmentManager = getFragmentManager ();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
                    fragmentTransaction.replace (R.id.frameLayout, fragment);
                    fragmentTransaction.commit ();
                }
                if (item.getItemId() ==R.id.DangKy){

                    fragment = new DangKyFragment();
                    FragmentManager fragmentManager = getFragmentManager ();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
                    fragmentTransaction.replace (R.id.frameLayout, fragment);
                    fragmentTransaction.commit ();
                }
                if (item.getItemId() ==R.id.LichHoc){

                    fragment = new LichHocFragment();
                    FragmentManager fragmentManager = getFragmentManager ();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
                    fragmentTransaction.replace (R.id.frameLayout, fragment);
                    fragmentTransaction.commit ();

                }
                if (item.getItemId() ==R.id.LichThi){

                    fragment = new LichThiFragment();
                    FragmentManager fragmentManager = getFragmentManager ();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
                    fragmentTransaction.replace (R.id.frameLayout, fragment);
                    fragmentTransaction.commit ();

                }
                    return true;
            }
        } );
    }
}
