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

import com.ratakondasneha.casestudy_sneha.api.ProramQuotesServiceGenerator;

import com.ratakondasneha.casestudy_sneha.model.ProgramQuotesInfo;

import com.ratakondasneha.casestudy_sneha.views.ProgramQuotesAdapter;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProgramQuotesFragment extends Fragment {
    RecyclerView recyclerView;
    private ProgramQuotesAdapter adapter;
    private ArrayList<ProgramQuotesInfo> programQuotesList;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_fragment_quotes, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        ProramQuotesServiceGenerator.getService().getProgramQuotesList().enqueue(new Callback<ArrayList<ProgramQuotesInfo>>() {
            @Override
            public void onResponse(Call<ArrayList<ProgramQuotesInfo>> call, Response<ArrayList<ProgramQuotesInfo>> response)
                {
                   programQuotesList = response.body();
                   adapter = new ProgramQuotesAdapter(programQuotesList);
                   recyclerView.setAdapter(adapter);
                }

        @Override
        public void onFailure(Call<ArrayList<ProgramQuotesInfo>> call, Throwable t) {

        }
    });

      return view;

 }

}
