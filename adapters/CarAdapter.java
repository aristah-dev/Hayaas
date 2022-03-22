package com.example.safarirides.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.safarirides.activity.BookCarDetails;
import com.example.safarirides.activity.BookingDetails;
import com.example.safarirides.R;
import com.example.safarirides.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {

    List<Car> carList;
    Context mctx;

    public CarAdapter( Context mctx, List<Car> carList) {
        this.carList = carList;
        this.mctx = mctx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mctx).inflate(R.layout.home_car_row_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Car car = carList.get(position);

        holder.car_model.setText(car.getModel());
        holder.car_price.setText(car.getBooking_price());


        String imageUrl = "http://10.0.2.2:8000/"+car.getImage_url();
        //String imageUrl = "http://192.168.43.155/safariRides/public/"+car.getImage_url();
        Glide.with(mctx)
                .load(imageUrl)
                .placeholder(R.drawable.car_placeholder)
                .into(holder.car_image);

        holder.car_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String seats_no =car.getSeats_no();
                String manufacturer= car.getManufacturer();
                String year= car.getYear();
                String milleage =car.getMilleage();
                String image_url="http://10.0.2.2:8000/"+car.getImage_url();
                //String image_url ="http://192.168.43.155/safariRides/public/"+car.getImage_url();

                String model=car.getModel();
                String status= car.getStatus();
                String description=car.getDescription();
                String booking_price =car.getBooking_price();
                String phone = car.getOwner_phone();

                Intent intent = new Intent(mctx.getApplicationContext(),BookCarDetails.class);
                intent.putExtra("seats_no",seats_no);
                intent.putExtra("manufacturer",manufacturer);
                intent.putExtra("year",year);
                intent.putExtra("milleage",milleage);
                intent.putExtra("image_url",image_url);
                intent.putExtra("model",model);
                intent.putExtra("phone",phone);
                intent.putExtra("status",status);
                intent.putExtra("description",description);
                intent.putExtra("booking_price",booking_price);

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mctx.getApplicationContext().startActivity(intent);
            }
        });


        holder.car_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phone = car.getOwner_phone();
                Intent inte = new Intent(mctx.getApplicationContext(), BookingDetails.class);
                inte.putExtra("owner_phone",phone);
                inte.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mctx.getApplicationContext().startActivity(inte);
            }
        });

    }

    @Override
    public int getItemCount() {


            return carList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView car_image;
        TextView car_model, car_price,car_details, car_book;
        RelativeLayout rl_home_hire;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            car_image= itemView.findViewById(R.id.img_car_image);
            car_model =itemView.findViewById(R.id.txt_car_model);
            car_price = itemView.findViewById(R.id.txt_car_price);
            car_details =itemView.findViewById(R.id.txt_car_details);
            car_book = itemView.findViewById(R.id.txt_car_book);
            rl_home_hire = itemView.findViewById(R.id.rl_home_hire);
        }
    }
}
