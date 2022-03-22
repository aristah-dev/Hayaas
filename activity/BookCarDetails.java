package com.example.safarirides.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.safarirides.R;

public class BookCarDetails extends AppCompatActivity implements View.OnClickListener {

    ImageView img_back_arrow_bk,img_car_bk;
    TextView car_title,txt_car_price,txt_seat_no_dt,txt_manufacturer_dt,txt_millage_dt,txt_details_dt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_car_details);


        initGui();
        img_back_arrow_bk.setOnClickListener(this);


        Bundle bundle = getIntent().getExtras();
        assert bundle != null;

        String seats_no = bundle.getString("seats_no");
        String manufacturer= bundle.getString("manufacturer");;
        String year= bundle.getString("year");;
        String milleage= bundle.getString("milleage");;
        String image_url= bundle.getString("image_url");;
        String model= bundle.getString("model");;
        String status= bundle.getString("status");;
        String description= bundle.getString("description");;
        String booking_price= bundle.getString("booking_price");;


        car_title.setText(model);
        txt_seat_no_dt.setText(seats_no);
        txt_car_price.setText(booking_price);
        txt_manufacturer_dt.setText(manufacturer);
        txt_millage_dt.setText( milleage);
        txt_details_dt.setText(description);




        Glide.with(getApplicationContext())
                .load(image_url)
                .placeholder(R.drawable.car_placeholder)
                .into(img_car_bk);




        img_back_arrow_bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initGui() {

        img_back_arrow_bk = findViewById(R.id.img_back_arrow_bk);
        car_title = findViewById(R.id.car_title);
        img_car_bk = findViewById(R.id.img_car_bk);
        txt_car_price = findViewById(R.id.txt_car_price);
        img_car_bk= findViewById(R.id.img_car_bk);
        txt_seat_no_dt = findViewById(R.id.txt_seat_no_dt);
        txt_manufacturer_dt = findViewById(R.id.txt_manufacturer_dt);
        txt_millage_dt = findViewById(R.id.txt_millage_dt);
        txt_details_dt = findViewById(R.id.txt_details_dt);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.img_back_arrow_bk:
            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);
        }
    }
}