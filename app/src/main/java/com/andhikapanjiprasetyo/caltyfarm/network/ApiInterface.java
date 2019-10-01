package com.andhikapanjiprasetyo.caltyfarm.network;

import com.andhikapanjiprasetyo.caltyfarm.ListSapiResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("sapi/get")
    Call<ListSapiResponse> getListSapi();
}
