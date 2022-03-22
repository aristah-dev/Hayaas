package com.example.safarirides;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class CompanyProfileActivity extends AppCompatActivity  implements View.OnClickListener{
   ImageView img_back_comp_prof;
    RecyclerView rcv_comp_profile;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_profile);


        Bundle bundle =getIntent().getExtras();
        assert bundle !=null;

        String comp_name = bundle.getString("company_name");
        int company_id = bundle.getInt("companyId");

        Log.d("Tadd",comp_name +" "+company_id);

        img_back_comp_prof = findViewById(R.id.img_back_comp_prof);
        rcv_comp_profile = findViewById(R.id.rcv_comp_profile);
        rcv_comp_profile.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        rcv_comp_profile.setLayoutManager(linearLayoutManager);
        img_back_comp_prof.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.img_back_comp_prof:
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                break;
        }
    }
}