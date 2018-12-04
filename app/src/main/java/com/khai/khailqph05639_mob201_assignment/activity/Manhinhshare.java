package com.khai.khailqph05639_mob201_assignment.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.khai.khailqph05639_mob201_assignment.R;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

public class Manhinhshare extends AppCompatActivity {
    private ImageView imgshare;
    private Button btnshare;
    private EditText edtieude;
    private EditText edmota;
    private EditText edurl;
    private Button btnShareLink;


    ShareDialog shareDialog;
    ShareLinkContent shareLinkContent;
    public static int Select_Image = 1;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_manhinhshare );
//        edtieude = (EditText) findViewById( R.id.edtieude );
//        edmota = (EditText) findViewById( R.id.edmota );
        edurl = (EditText) findViewById( R.id.edurl );
        btnShareLink = (Button) findViewById( R.id.btnShareLink );
        shareDialog = new ShareDialog( Manhinhshare.this );
        imgshare = (ImageView) findViewById( R.id.imgshare );
        btnshare = (Button) findViewById( R.id.btnshare );

        btnShareLink.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ShareDialog.canShow( ShareLinkContent.class )){

                    shareLinkContent = new ShareLinkContent.Builder()
//                            .setContentTitle( edtieude.getText().toString() )
//                            .setContentDescription( edmota.getText().toString() )
                            .setContentUrl( Uri.parse( edurl.getText().toString() ) ).build();
                }
                shareDialog.show( shareLinkContent );
            }
        } );
        imgshare.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Intent.ACTION_PICK );
                intent.setType( "image/*" );
                startActivityForResult( intent, Select_Image );
            }
        } );
        btnshare.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharePhoto photo = new SharePhoto.Builder().setBitmap( bitmap )
                        .build();
                SharePhotoContent content = new SharePhotoContent.Builder()
                        .addPhoto( photo ).build();
                shareDialog.show( content );
            }
        } );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Select_Image && resultCode == RESULT_OK) {


            try {
                InputStream inputStream = getContentResolver().openInputStream( data.getData() );
                bitmap = BitmapFactory.decodeStream( inputStream );
                imgshare.setImageBitmap( bitmap );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        super.onActivityResult( requestCode, resultCode, data );
    }
}
