package com.example.safarirides.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.safarirides.CompanyProfileActivity;
import com.example.safarirides.R;
import com.example.safarirides.model.CompanyModel;

import java.util.List;

public class AllCompanyCarsAdapter extends RecyclerView.Adapter<AllCompanyCarsAdapter.MyViewHolder> {

Context mctxt;
List<CompanyModel> carList;

    public AllCompanyCarsAdapter(Context mctxt, List<CompanyModel> carList) {
        this.mctxt = mctxt;
        this.carList = carList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mctxt).inflate(R.layout.list_row_companies,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

      CompanyModel data = carList.get(position);
      holder.comp_name.setText(data.getName());
      holder.comp_services.setText(data.getServices());
      holder.comp_motto.setText(data.getMotto());

      int company_id = data.getId();
      String company_name = data.getName();

        String imageUrl = "http://10.0.2.2:8000/"+data.getImage();
        //String imageUrl = "http://192.168.43.155/safariRides/public/"+car.getImage();
        Glide.with(mctxt)
                .load(imageUrl)
                .placeholder(R.drawable.car_placeholder)
                .into(holder.comp_car_image);


        holder.comp_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mctxt.getApplicationContext(), CompanyProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("companyId",company_id);
                intent.putExtra("company_name",company_name);
                mctxt.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView comp_car_image;
        TextView comp_name, comp_motto, comp_services;
        LinearLayout comp_ll;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            comp_car_image = itemView.findViewById(R.id.comp_car_image);
            comp_name = itemView.findViewById(R.id.comp_name);
            comp_motto= itemView.findViewById(R.id.comp_motto);
            comp_services = itemView.findViewById(R.id.comp_services);
            comp_ll = itemView.findViewById(R.id.comp_ll);
        }
    }
}
