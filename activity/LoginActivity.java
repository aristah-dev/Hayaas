package com.example.safarirides.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safarirides.R;
import com.example.safarirides.activity.ForgetPasswordActivity;
import com.example.safarirides.activity.HomeActivity;
import com.example.safarirides.activity.RegisterActivity;
import com.example.safarirides.network.ApiClient;
import com.example.safarirides.model.LoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    String SHAREPREFFILE;
    SharedPreferences preferences;
    SharedPreferences.Editor editor ;

    Button btn_login;
    EditText edtxt_email, edtxt_password;
    TextView txtForgetPswd,txtSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        preferences = getSharedPreferences(SHAREPREFFILE,MODE_PRIVATE);
        editor = preferences.edit();

        if(preferences.getBoolean("login_status",false)) {
            startActivity(new Intent(getApplicationContext(),HomeActivity.class));
        }



        //initialise nwidgets
        init();

 //

        txtForgetPswd.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = edtxt_email.getText().toString();
                String password = edtxt_password.getText().toString();



                Call <LoginModel> call = ApiClient.getApiService().loginUser(email,password);

                call.enqueue(new Callback<LoginModel>() {
                    @Override
                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                        LoginModel user = response.body();
                      if(response.isSuccessful())
                      {

                          String user_id = user.getId();
                          String token = user.getAccess_token();



                          editor.putString("user_id",user_id);
                          editor.putBoolean("login_status",true);
                          editor.putString("token",token);

                          editor.commit();
                          Toast.makeText(getApplicationContext(),"Login Successful"+user_id,Toast.LENGTH_LONG).show();
                          startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                      }
                      else
                      {
                          Toast.makeText(getApplicationContext(),"Wrong Login Details ",Toast.LENGTH_LONG).show();
                      }

                        //Toast.makeText(getApplicationContext(),user.getAccess_token(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<LoginModel> call, Throwable t) {
                        Log.d("TAGG",t.getMessage());
                        Toast.makeText(getApplicationContext(),"Oooops Sometinh Wrong Happened, Try Again ",Toast.LENGTH_LONG).show();
                    }
                }
                );


            }
        });

    }

    public void init()
    {
        btn_login = findViewById(R.id.btn_login);
        edtxt_email =findViewById(R.id.edtxt_email_login);
        edtxt_password = findViewById(R.id.edtxt_password_login);
        txtForgetPswd = findViewById(R.id.txt_forget_pswd);
        txtSignUp =findViewById(R.id.txt_sign_up);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txt_forget_pswd:
                startActivity(new Intent(getApplicationContext(), ForgetPasswordActivity.class));
                break;
            case R.id.txt_sign_up:
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                break;
            default:
                   break;
        }

    }
}