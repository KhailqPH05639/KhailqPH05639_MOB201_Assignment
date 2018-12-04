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



public class LichThiFragment extends Fragment {
    private View lichhoc;
    private RecyclerView faLichThi;

    private List<LichHoc> lichHocList;
    private LichHocAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        lichhoc = inflater.inflate( R.layout.lichthifragment, container, false );

         faLichThi= lichhoc.findViewById( R.id.faLichThi );


        lichHocList = new ArrayList<>();

        lichHocList.add(new LichHoc("Chủ Nhật,Ngày 9/12/2018","D408","Dự An 1","Nguyễn Hữu Huy"));
        lichHocList.add(new LichHoc("Thứ 5,Ngày 13/12/2018","D412","Android Nâng Cao","Nguyễn Hữu Huy"));
        lichHocList.add(new LichHoc("Thứ 2,Ngày 24/12/2018","D416","Tiếng Anh 2.2","Do Quynh Hoa"));
        adapter = new LichHocAdapter(lichHocList);
        faLichThi.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        faLichThi.setLayoutManager(manager);
        return lichhoc;
    }
}
