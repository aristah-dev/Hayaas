package com.example.safarirides.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safarirides.R;
import com.example.safarirides.activity.HomeActivity;
import com.example.safarirides.adapters.CarAdapter;
import com.example.safarirides.model.Car;
import com.example.safarirides.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchCarActivity extends AppCompatActivity implements  View.OnClickListener{

    RecyclerView rcv_search;
    List<Car> dataList;
    CarAdapter adapter;
    LinearLayoutManager layoutManager;
    TextView not_found;
    ImageView img_back_search;
    String carType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_car);


        //init Widgets
        initGui();


        Bundle bundle = getIntent().getExtras();
        assert bundle != null;

        carType = bundle.getString("carType");
        Toast.makeText(getApplicationContext(),carType,Toast.LENGTH_LONG).show();

        //searc Car By Type
        searchCarByType();

        img_back_search.setOnClickListener(this);
    }

    private void initGui() {
        img_back_search = findViewById(R.id.img_back_search);
        rcv_search = findViewById(R.id.rcv_search);
        layoutManager =new LinearLayoutManager(this);
        rcv_search.setHasFixedSize(true);
        rcv_search.setLayoutManager(layoutManager);
        not_found = findViewById(R.id.txt_not_found);
    }


    //search car by passed type
    private void searchCarByType() {
        Call<List<Car>> call = ApiClient.getApiService().getSpecificCarType(carType);
        call.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {

                if(response.body().size()>=1) {
                    dataList = response.body();
                    adapter = new CarAdapter(getApplicationContext(), dataList);
                    rcv_search.setAdapter(adapter);
                }
                else
                {
                    rcv_search.setVisibility(View.GONE);
                    not_found.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.img_back_search:
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            break;
        }
    }
}