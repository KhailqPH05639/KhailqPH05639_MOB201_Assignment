package com.khai.khailqph05639_mob201_assignment.database.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khai.khailqph05639_mob201_assignment.R;
import com.khai.khailqph05639_mob201_assignment.database.model.LichHoc;

import java.util.List;

public class LichHocAdapter extends RecyclerView.Adapter<LichHocAdapter.ViewHodel> {
    private List<LichHoc> lichHocList;

    public LichHocAdapter(List<LichHoc> lichHocList) {
        this.lichHocList = lichHocList;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_lichhoc,parent,false);
        return new ViewHodel( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, int position) {
        LichHoc sv = lichHocList.get(position);
        holder.tvGvHoc.setText("Giáo Viên :"+sv.getTvGvHoc());
        holder.tvMonHoc.setText("Môn :"+sv.getTvMonHoc());
        holder.tvNgayHoc.setText(sv.getTvNgayHoc());
        holder.tvPhongHoc.setText("Phòng :"+sv.getTvPhongHoc());
    }

    @Override
    public int getItemCount() {
        return  lichHocList.size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder {
        private TextView tvNgayHoc;
        private TextView tvPhongHoc;
        private TextView tvMonHoc;
        private TextView tvGvHoc;

        public ViewHodel(View itemView) {
            super( itemView );
            tvNgayHoc = (TextView) itemView.findViewById(R.id.tvNgayHoc);
            tvPhongHoc = (TextView) itemView.findViewById(R.id.tvPhongHoc);
            tvMonHoc = (TextView) itemView.findViewById(R.id.tvMonHoc);
            tvGvHoc = (TextView) itemView.findViewById(R.id.tvGvHoc);
        }
    }
}
