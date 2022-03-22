package com.example.safarirides.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.safarirides.R;
import com.example.safarirides.SelectSeatActivity;
import com.example.safarirides.model.SpecificCompanyModel;

import java.util.List;

public class SpecificCompanyCarsAdapter extends RecyclerView.Adapter<SpecificCompanyCarsAdapter.MyViewHolder> {

    Context mctxt;
    List<SpecificCompanyModel> carList;

    public SpecificCompanyCarsAdapter(Context mctxt, List<SpecificCompanyModel> carList) {
        this.mctxt = mctxt;
        this.carList = carList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mctxt).inflate(R.layout.row_item_specific_company_cars, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SpecificCompanyModel data = carList.get(position);

        holder.bus_route.setText(data.getRoute());
        holder.pick_up_point.setText(data.getPickup_office());
        holder.arrival_time.setText(data.getArrival());
        holder.departure_time.setText(data.getDeparture());
        holder.bus_fare.setText(data.getPrice());

        String image_url="http://10.0.2.2:8000/"+data.getImage();
        //String image_url ="http://192.168.43.155/safariRides/public/"+car.getImage();

        Glide.with(mctxt)
                .load(image_url)
                .placeholder(R.drawable.car_placeholder)
                .into(holder.img_spec_comp_car_img);

        holder.btn_spec_comp_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mctxt.getApplicationContext(), SelectSeatActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mctxt.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView img_spec_comp_car_img;
        TextView bus_route,pick_up_point,arrival_time,departure_time,bus_fare;
        Button btn_spec_comp_book;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img_spec_comp_car_img=itemView.findViewById(R.id.img_spec_comp_car_img);
            bus_route=itemView.findViewById(R.id. bus_route);
            pick_up_point=itemView.findViewById(R.id.pick_up_point);
            arrival_time=itemView.findViewById(R.id.arrival_time);
            departure_time=itemView.findViewById(R.id.departure_time);
            bus_fare=itemView.findViewById(R.id.bus_fare);
            btn_spec_comp_book = itemView.findViewById(R.id.btn_spec_comp_book);
        }
    }
}
