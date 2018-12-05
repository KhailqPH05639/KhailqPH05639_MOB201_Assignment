package com.khai.khailqph05639_mob201_assignment.database.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.khai.khailqph05639_mob201_assignment.R;
import com.khai.khailqph05639_mob201_assignment.database.sqlite.UserDAO;
import com.khai.khailqph05639_mob201_assignment.database.holder.UserHolder;
import com.khai.khailqph05639_mob201_assignment.database.model.User;

import java.util.List;



public class AdapterUser extends RecyclerView.Adapter<UserHolder> {
    private Context context;
    private List<User> users;
    private UserDAO userDAO;

    public AdapterUser(Context context, List<User> users, UserDAO userDAO) {
        this.context = context;
        this.users = users;
        this.userDAO = userDAO;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( context ).inflate( R.layout.item_nguoidung,parent,false );
        return new UserHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, final int position) {
     final User user = users.get( position );
      holder.tvId.setText( "Môn :"+user.id );
      holder.tvTen.setText("Name :"+ user.name );
      holder.tvSdt.setText( "Email :"+user.phone );
      holder.imgxoa.setOnClickListener( new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              long result = userDAO.deleteUser( user.id );
           users.remove( position );
           notifyDataSetChanged();
          }
      } );
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
