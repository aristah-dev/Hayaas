package com.example.safarirides.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.safarirides.activity.LoginActivity;

public class UserSession {


    Context mctx;
    String SHARED_PREF_FILE;

    SharedPreferences sharedPreferences = mctx.getSharedPreferences(SHARED_PREF_FILE,Context.MODE_PRIVATE);

    SharedPreferences.Editor editor = sharedPreferences.edit();

    public void storeDetails()
    {

    }
}
