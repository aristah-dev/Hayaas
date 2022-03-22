package com.example.safarirides.network;

import com.example.safarirides.model.BookAppointmentModel;
import com.example.safarirides.model.Car;
import com.example.safarirides.model.CompanyModel;
import com.example.safarirides.model.LoginModel;
import com.example.safarirides.model.UserModel;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {


    @GET("safarirides")
    Call<UserModel> getUser();

    //Register user
    @FormUrlEncoded
    @POST("register")
    Call<UserModel> createUser(@Field("name") String name,
                               @Field("email") String email,
                               @Field("password") String password,
                               @Field("password_confirmation") String c_password);

    //Login user]
    @FormUrlEncoded
    @POST("login")
    Call<LoginModel> loginUser(@Field("email") String email,
                               @Field("password") String password);

    //get All Available cars for booking
    @GET("bookcars")
    Call<List<Car>>  getAllCars();

    @GET("bookinghistory/{user_id}")
    Call<List<BookAppointmentModel>> getCarBkHistory(@Path("user_id") String user_id);

    @GET("bookcars/{carType}")
    Call<List<Car>> getSpecificCarType(@Path("carType") String carType);

    @FormUrlEncoded
    @POST("hirecar")
    Call<BookAppointmentModel> hireCar(@Field("user_id") String user_id,
                                       @Field("bk_pickup_date") String bk_pickup_date,
                                       @Field("bk_dropoff_date") String bk_dropoff_date,
                                       @Field("bk_status") String bk_status,
                                       @Field("booking_ref_no") String booking_ref_no,
                                       @Field("phone") String owner_phone);



    @GET("getCompaniesProfile")
    Call<List<CompanyModel>> getCompanies();

}
