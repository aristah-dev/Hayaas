package com.example.safarirides.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safarirides.R;
import com.example.safarirides.network.ApiClient;
import com.example.safarirides.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {


    TextView textView;
    EditText edtxt_username, edtxt_email, edtxt_password, edtxt_confirmed_password;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        init();
        //Register button click
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtxt_username.getText().toString().trim();
                String Email = edtxt_email.getText().toString().trim();
                String passWord = edtxt_password.getText().toString();
                String C_password = edtxt_confirmed_password.getText().toString().trim();

                if(passWord.equals(""))
                {
                    edtxt_password.setError("Password Is Required");
                }
                else if(Email.equals(""))
                {
                    edtxt_email.setError("Email is Required");
                }
                else if(userName.equals(""))
                {
                   edtxt_username.setError("userName is Required");
                }

                else
                {
                    Call<UserModel> call = ApiClient.getApiService().createUser(userName,Email,passWord,C_password);
                    call.enqueue(new Callback<UserModel>() {
                        @Override
                        public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                                Toast.makeText(getApplicationContext(),"User registered Successfully ",Toast.LENGTH_LONG).show();


                        }

                        @Override
                        public void onFailure(Call<UserModel> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),"Sign Up Failed, Try Again!! ",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });



        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init()
    {
        textView = findViewById(R.id.txtv_to_login);
        btnRegister= findViewById(R.id.btn_reg_register);
        edtxt_username = findViewById(R.id.edtxt_reg_username);
        edtxt_email = findViewById(R.id.edtxt_reg_email);
        edtxt_password = findViewById(R.id.edtxt_reg_password);
        edtxt_confirmed_password = findViewById(R.id.edtxt_reg_c_password);
    }
}