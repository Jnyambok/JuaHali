package com.juliusnyambok.RecyclerView;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



//This is the outer class for the JSON response
public class OuterClass {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("disaster")
    @Expose
    private List<DisasterModel> disaster;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DisasterModel> getDisaster() {
        return disaster;
    }

    public void setDisaster(List<DisasterModel> disaster) {
        this.disaster = disaster;
    }

}