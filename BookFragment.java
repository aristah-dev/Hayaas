package com.example.safarirides;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.safarirides.adapters.AllCompanyCarsAdapter;
import com.example.safarirides.model.CompanyModel;
import com.example.safarirides.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookFragment extends Fragment {

RecyclerView rcv_book;
LinearLayoutManager layoutManager;
List<CompanyModel> carList;
AllCompanyCarsAdapter adapter;

    public BookFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_book, container, false);
        rcv_book= view.findViewById(R.id.rcv_book);

        rcv_book.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(view.getContext());
        rcv_book.setLayoutManager(layoutManager);



        Call<List<CompanyModel>> call = ApiClient.getApiService().getCompanies();
        call.enqueue(new Callback<List<CompanyModel>>() {
            @Override
            public void onResponse(Call<List<CompanyModel>> call, Response<List<CompanyModel>> response) {
                carList = response.body();
                adapter = new AllCompanyCarsAdapter(getContext(),carList);
                rcv_book.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<CompanyModel>> call, Throwable t) {

            }
        });


        return view;
    }


}