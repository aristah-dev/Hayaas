package com.example.safarirides.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safarirides.AboutAppActivity;
import com.example.safarirides.R;
import com.example.safarirides.adapters.CarAdapter;
import com.example.safarirides.model.Car;
import com.example.safarirides.network.ApiClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements  View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    RecyclerView recyclerview;
    //arr
    List<Car> carList;
    CarAdapter adapter;
    LinearLayoutManager layoutManager;
    FloatingActionButton fab;

    EditText edtxt_item_to_search;
    Button btn_search;
    ImageView img_filter,img_menu;
    TextView txt_filter;
    CardView cv;

    int count;

    String SHAREPREFFILE;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fab = findViewById(R.id.fab);
        edtxt_item_to_search= findViewById(R.id.edtxt_item_to_search);
        btn_search =findViewById(R.id.btn_search);
        img_filter= findViewById(R.id.img_filter);
        txt_filter =findViewById(R.id.txt_filter);
        img_menu=findViewById(R.id.img_menu);
        cv=findViewById(R.id.cv);



        img_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),img_menu);
                popupMenu.inflate(R.menu.top_nav_menu);
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(HomeActivity.this);
            }
        });


        //View bottomSheet = findViewById(R.id.bottom_sheet);

        //bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        recyclerview= findViewById(R.id.rcv);
        recyclerview.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);

         count = 2;



   btn_search.setOnClickListener(this);
   fab.setOnClickListener(this);
   img_filter.setOnClickListener(this);



      Call<List<Car>> call = ApiClient.getApiService().getAllCars();

      call.enqueue(new Callback<List<Car>>() {
          @Override
          public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {

              carList = response.body();

              Log.d("Tag",carList.toString());

              adapter = new CarAdapter(getApplicationContext(),carList);

              recyclerview.setAdapter(adapter);
          }

          @Override
          public void onFailure(Call<List<Car>> call, Throwable t) {

          }
      });



    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btn_search:
                openSearchActivity();
                break;

            case R.id.fab:
                openHireHistory();
                break;
            case R.id.img_filter:
                 openSearchView();
                 break;

        }
    }

    //open search Results
    private void openSearchActivity() {

        String cartype =  edtxt_item_to_search.getText().toString();

        if(cartype.isEmpty())
        {
            edtxt_item_to_search.setError("Car Type Can not be Empty");
        }
        else {
            Intent intent = new Intent(getApplicationContext(), SearchCarActivity.class);
            intent.putExtra("carType", cartype);
            startActivity(intent);
        }
    }

    //make search view visible
    private void openSearchView() {


        count++;

        if(count%2==0)
        {
            cv.setVisibility(View.GONE);
        }
        else
        {
            cv.setVisibility(View.VISIBLE);
        }
    }


    //open user car Hire History
    public void openHireHistory()
    {
        Intent  intent = new Intent(getApplicationContext(), MyBookingHistory.class);
        startActivity(intent);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.logout:
                SharedPreferences sharedPreferences = getSharedPreferences(SHAREPREFFILE,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("login_status",false);
                editor.clear().commit();
                Toast.makeText(getApplicationContext(), "Logout Out Successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

                break;

            case R.id.settings:
                //startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                break;
            case R.id.about:
                startActivity(new Intent(getApplicationContext(), AboutAppActivity.class));
                break;

        }
        return true;
    }

}
