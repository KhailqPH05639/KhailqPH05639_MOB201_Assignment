package com.khai.khailqph05639_mob201_assignment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khai.khailqph05639_mob201_assignment.R;
import com.khai.khailqph05639_mob201_assignment.database.adapter.LichHocAdapter;
import com.khai.khailqph05639_mob201_assignment.database.model.LichHoc;

import java.util.ArrayList;
import java.util.List;


public class LichHocFragment extends Fragment {
    private View lichhoc;
    private RecyclerView faLichHoc;

    private List<LichHoc> lichHocList;
    private LichHocAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        lichhoc = inflater.inflate( R.layout.lichhocfragment, container, false );

        faLichHoc = lichhoc.findViewById( R.id.faLichhoc );


        lichHocList = new ArrayList<>();

        lichHocList.add( new LichHoc( "Thứ 3,Ngày 27/11/2018", "D402", "Tiếng Anh 2.2", "Do Quynh Hoa" ) );
        lichHocList.add( new LichHoc( "Thứ 4,Ngày 28/11/2018", "D408", "Dự Án 1", "Nguyễn Hữu Huy" ) );
        lichHocList.add( new LichHoc( "Thứ 5,Ngày 29/11/2018", "D412", "Android Nâng Cao", "Nguyễn Hữu Huy" ) );
        lichHocList.add( new LichHoc( "Thứ 2,Ngày 2/12/2018", "D408", "Dự Án 1", "Nguyễn Hữu Huy" ) );
        lichHocList.add( new LichHoc( "Thứ 3,Ngày 3/12/2018", "D412", "Android Nâng Cao", "Nguyễn Hữu Huy" ) );
        lichHocList.add( new LichHoc( "Thứ 3,Ngày 3/12/2018", "D402", "Tiếng Anh 2.2", "Do Quynh Hoa" ) );
        lichHocList.add( new LichHoc( "Thứ 4,Ngày 4/12/2018", "D408", "Dự Án 1", "Nguyễn Hữu Huy" ) );
        lichHocList.add( new LichHoc( "Thứ 5,Ngày 3/12/2018", "D402", "Tiếng Anh 2.2", "Do Quynh Hoa" ) );
        lichHocList.add( new LichHoc( "Thứ 5,Ngày 5/12/2018", "D412", "Android Nâng Cao", "Nguyễn Hữu Huy" ) );
        lichHocList.add( new LichHoc( "Thứ 6,Ngày 4/12/2018", "D408", "Dự Án 1", "Nguyễn Hữu Huy" ) );
        lichHocList.add( new LichHoc( "Thứ 7,Ngày 6/12/2018", "D412", "Android Nâng Cao", "Nguyễn Hữu Huy" ) );
        lichHocList.add( new LichHoc( "Thứ 2,Ngày 7/12/2018", "D408", "Dự Án 1", "Nguyễn Hữu Huy" ) );

        adapter = new LichHocAdapter( lichHocList );
        faLichHoc.setAdapter( adapter );
        RecyclerView.LayoutManager manager = new LinearLayoutManager( getActivity() );
        faLichHoc.setLayoutManager( manager );
        return lichhoc;
    }
}
