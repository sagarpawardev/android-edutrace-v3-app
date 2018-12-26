package com.sgrpwr.collegepreditctor.common.api;

import com.sgrpwr.collegepreditctor.activities.collegelist.api.model.CollegeListAPIModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("search")
    Call<CollegeListAPIModel> getCollegeList();
}
