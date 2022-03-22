package com.example.safarirides.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safarirides.R;
import com.example.safarirides.model.BookAppointmentModel;
import com.example.safarirides.network.ApiClient;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingDetails extends AppCompatActivity {

    Button btn_continue_booking;
    TextView txt_selected_pickup_date,txt_selected_dropoff_date,txt_selected_pk_date,txt_selected_do_date;
    DatePickerDialog picker;
    String user_id,bk_pickup_date, bk_dropoff_date,bk_status, owner_phone,booking_ref_no;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);


        Bundle bundle = getIntent().getExtras();
        assert bundle != null;

        owner_phone = bundle.getString("owner_phone");


        booking_ref_no="SR674";



        btn_continue_booking = findViewById(R.id.btn_continue_booking);
        txt_selected_pickup_date = findViewById(R.id.txt_selected_pickup_date);
        txt_selected_pk_date =findViewById(R.id.txt_selected_pk_date);

        txt_selected_dropoff_date = findViewById(R.id.txt_selected_dropoff_date);
        txt_selected_do_date =findViewById(R.id.txt_selected_do_date);


        bk_status ="0";
        user_id ="1";



        txt_selected_pk_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(BookingDetails.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                txt_selected_pickup_date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                                bk_pickup_date = txt_selected_pickup_date.getText().toString();
                            }
                        }, year, month, day);
                picker.show();
            }
        });


//selecting drop off time
        txt_selected_do_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(BookingDetails.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                txt_selected_dropoff_date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);


                                bk_dropoff_date = txt_selected_dropoff_date.getText().toString();
                            }
                        }, year, month, day);
                picker.show();
            }
        });


        btn_continue_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                performBooking();

            }
        });
    }



    public void performBooking()
    {

        Toast.makeText(getApplicationContext(),owner_phone,Toast.LENGTH_LONG).show();

        Log.d("TAGG",user_id+ " "+bk_pickup_date+ " "+bk_dropoff_date+ " "+bk_status+ " "+booking_ref_no+ " "+owner_phone);

        Call<BookAppointmentModel> call = ApiClient.getApiService().hireCar(user_id,bk_pickup_date, bk_dropoff_date,bk_status,booking_ref_no,owner_phone);
        call.enqueue(new Callback<BookAppointmentModel>() {
            @Override
            public void onResponse(Call<BookAppointmentModel> call, Response<BookAppointmentModel> response) {

                Intent intent = new Intent(getApplicationContext(), BookingConfirmation.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<BookAppointmentModel> call, Throwable t) {

            }
        });
    }
}