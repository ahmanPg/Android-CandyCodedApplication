package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {
    private TextView address_tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


        address_tv = (TextView) findViewById(R.id.text_view_address);
       address_tv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               createMapIntent(view);
           }
       });
    }
    public void createMapIntent(View view){
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null)
                    startActivity(mapIntent);

    }



    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***


    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
}
