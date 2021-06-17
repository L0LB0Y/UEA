package com.example.uaenew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        Intent intent = getIntent();
        String imgUrl = intent.getStringExtra("imgUrl");
        String author = intent.getStringExtra("author");
        String title = intent.getStringExtra("title");
        String dec = intent.getStringExtra("description");
        ImageView imageView = (ImageView)findViewById(R.id.image2);
        Picasso.get().load(imgUrl).into(imageView);
        TextView textAuth = (TextView)findViewById(R.id.author2);
        textAuth.setText(author);
        TextView textTitle = (TextView)findViewById(R.id.title2);
        textTitle.setText(title);
        TextView txtDec = (TextView)findViewById(R.id.description);
        txtDec.setText(dec);
    }
}