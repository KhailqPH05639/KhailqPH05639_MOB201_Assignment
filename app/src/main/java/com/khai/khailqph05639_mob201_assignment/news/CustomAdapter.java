package com.khai.khailqph05639_mob201_assignment.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.khai.khailqph05639_mob201_assignment.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Read> {
    private List<Read> listRead;

    public CustomAdapter(Context context, int resource, List<Read> items) {
        super( context, resource, items );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from( getContext() );
            view = inflater.inflate( R.layout.dong_layout_listview, null );
        }
        Read p = getItem( position );
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView txttitle = (TextView) view.findViewById( R.id.tvTiitle );
            txttitle.setText( p.title );
            ImageView imageView = view.findViewById( R.id.imageview );
            Picasso.with( getContext() ).load( p.image ).into( imageView );
        }
//        Animation animation = AnimationUtils.loadAnimation( getContext(), R.anim.scale_listview );
//        view.startAnimation( animation );
        return view;
    }
}
