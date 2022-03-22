package com.example.safarirides.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.safarirides.R;
import com.example.safarirides.activity.HomeActivity;
import com.example.safarirides.adapters.BkHistoryAdapter;
import com.example.safarirides.model.BookAppointmentModel;
import com.example.safarirides.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyBookingHistory extends AppCompatActivity {

    ImageView img_back_bk_hs;
    RecyclerView rcv;
    BkHistoryAdapter adapter;
    List<BookAppointmentModel> dataList;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking_history);

        String id = "1";


        img_back_bk_hs = findViewById(R.id.img_back_bk_hs);
        rcv = findViewById(R.id.rcv_bk_history);
        rcv.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rcv.setLayoutManager(layoutManager);




        img_back_bk_hs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        Call<List<BookAppointmentModel>> cll = ApiClient.getApiService().getCarBkHistory(id);
        cll.enqueue(new Callback<List<BookAppointmentModel>>() {
            @Override
            public void onResponse(Call<List<BookAppointmentModel>> call, Response<List<BookAppointmentModel>> response) {
                dataList = response.body();

                adapter = new BkHistoryAdapter(getApplicationContext(),dataList);
                rcv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<BookAppointmentModel>> call, Throwable t) {

            }
        });
    }
}