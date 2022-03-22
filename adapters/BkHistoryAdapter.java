package com.example.safarirides.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safarirides.R;
import com.example.safarirides.model.BookAppointmentModel;

import java.util.List;

public class BkHistoryAdapter extends RecyclerView.Adapter<BkHistoryAdapter.MyViewHolder> {

    Context context;
    List<BookAppointmentModel> dataList;

    public BkHistoryAdapter(Context context, List<BookAppointmentModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.appointment_history_row_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        BookAppointmentModel model = dataList.get(position);

        holder.txt_bk_ref.setText(model.getBooking_ref_no());
        holder.txt_bk_pickup_date.setText(model.getBk_pickup_date());
        holder.txt_bk_dropoff_date.setText(model.getBk_dropoff_date());

        if(model.getBk_status().equals("0"))
        {
            holder.txt_bk_status.setText("Pending");
        }
        else if(model.getBk_status().equals("1"))
        {
            holder.txt_bk_status.setText("Accepted");
            holder.txt_bk_status.setBackgroundColor(Color.GREEN);
            holder. txt_call_label.setVisibility(View.GONE);
            holder.img_call.setVisibility(View.GONE);
        }
        else
        {
            holder.txt_bk_status.setText("Rejected");
            holder.txt_bk_status.setBackgroundColor(Color.MAGENTA);
            holder. txt_call_label.setVisibility(View.GONE);
            holder.img_call.setVisibility(View.GONE);
        }

        holder.img_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context.getApplicationContext(), "Call Owner", Toast.LENGTH_SHORT).show();
                String phone_no = model.getPhone();
                Uri number = Uri.parse("tel:"+phone_no);
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                context.getApplicationContext().startActivity(callIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_bk_ref,txt_bk_pickup_date,txt_bk_dropoff_date,txt_bk_status,txt_call_label;
        ImageView img_call,img_ic_dots;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img_call = itemView.findViewById(R.id.img_call);
            img_ic_dots = itemView.findViewById(R.id.img_ic_dots);

            txt_bk_ref = itemView.findViewById(R.id.txt_bk_ref);
            txt_bk_pickup_date = itemView.findViewById(R.id.txt_bk_pickup_date);
            txt_bk_dropoff_date = itemView.findViewById(R.id.txt_bk_dropoff_date);
            txt_bk_status = itemView.findViewById(R.id.txt_bk_status);
            txt_call_label =itemView.findViewById(R.id.txt_call_label);




        }
    }
}
