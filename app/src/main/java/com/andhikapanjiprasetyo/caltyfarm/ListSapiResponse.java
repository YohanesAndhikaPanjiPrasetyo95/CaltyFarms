package com.andhikapanjiprasetyo.caltyfarm;

import com.andhikapanjiprasetyo.caltyfarm.model.SapiModel;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ListSapiResponse {

    @SerializedName("data")
    public ArrayList<SapiModel> data;
}
