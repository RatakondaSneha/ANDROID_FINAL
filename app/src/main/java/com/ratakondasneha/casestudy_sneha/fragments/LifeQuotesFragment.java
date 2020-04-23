package com.ratakondasneha.casestudy_sneha.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ratakondasneha.casestudy_sneha.R;
import com.ratakondasneha.casestudy_sneha.api.LifeQuotesServiceGenerator;
import com.ratakondasneha.casestudy_sneha.model.LifeQuotesList;
import com.ratakondasneha.casestudy_sneha.views.LifeQuotesAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LifeQuotesFragment extends Fragment {
    RecyclerView recyclerView;
    private LifeQuotesAdapter adapter;
    private LifeQuotesList lifeQuotesList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.view_fragment_quotes,container,false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        LifeQuotesServiceGenerator.getService().getLifeQuotesList().enqueue(new Callback<LifeQuotesList>(){
            @Override
            public void onResponse(Call<LifeQuotesList> call, Response<LifeQuotesList> response){

                lifeQuotesList = response.body();
                adapter = new LifeQuotesAdapter(lifeQuotesList.getQuotesArray());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<LifeQuotesList> call, Throwable t){

            }
        });
        return view;
    }
}
