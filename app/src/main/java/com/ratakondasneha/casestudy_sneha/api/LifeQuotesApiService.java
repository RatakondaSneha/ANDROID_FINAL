package com.ratakondasneha.casestudy_sneha.api;

import com.ratakondasneha.casestudy_sneha.model.LifeQuotesList;
import com.ratakondasneha.casestudy_sneha.model.LifeQuotesInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LifeQuotesApiService {

    @GET("v2/quotes/all?page=1&limit=100")
    Call<LifeQuotesList> getLifeQuotesList();

    @GET("v2/quotes/random")
    Call<LifeQuotesList> getLifeRandomQuote();

}
