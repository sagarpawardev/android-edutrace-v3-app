package com.sgrpwr.collegepreditctor.common.api;

import com.sgrpwr.collegepreditctor.config.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIBuilder {
    private APIBuilder(){

    }

    public static API getAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        API api = retrofit.create(API.class);
        return api;
    }
}
