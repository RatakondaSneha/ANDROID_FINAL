package com.ratakondasneha.casestudy_sneha.api;

import com.ratakondasneha.casestudy_sneha.model.LifeQuotesList;
import com.ratakondasneha.casestudy_sneha.model.ProgramQuotesInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.ArrayList;

public interface ProgramQuotesApiService {
    @GET("quotes")
    Call<ArrayList<ProgramQuotesInfo>> getProgramQuotesList();

    @GET("quotes/random")
    Call<ProgramQuotesInfo> getProgramRandomQuote();

}
