package com.ratakondasneha.casestudy_sneha.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProramQuotesServiceGenerator {
    private static ProgramQuotesApiService SERVICE;

    private static void initialize()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://programming-quotes-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        SERVICE = retrofit.create(ProgramQuotesApiService.class);
    }

    public static ProgramQuotesApiService getService(){

        if (SERVICE == null){
            initialize();
        }

        return SERVICE;
    }
}
