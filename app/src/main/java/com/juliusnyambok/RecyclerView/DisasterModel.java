package com.juliusnyambok.RecyclerView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//This is the model class for the JSON resonse.It is responsible for creating objects containing necessary data for each disaster.
//It is also the inner model class for the JSON response
class DisasterModel{

    @SerializedName("responseStatus")
    @Expose
    private String responseStatus;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("disasterName")
    @Expose
    private String disasterName;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("dateDiscovered")
    @Expose
    private String dateDiscovered;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisasterName() {
        return disasterName;
    }

    public void setDisasterName(String disasterName) {
        this.disasterName = disasterName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateDiscovered() {
        return dateDiscovered;
    }

    public void setDateDiscovered(String dateDiscovered) {
        this.dateDiscovered = dateDiscovered;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "DisasterModel{" +
                "responseStatus='" + responseStatus + '\'' +
                ", id='" + id + '\'' +
                ", disasterName='" + disasterName + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", dateDiscovered='" + dateDiscovered + '\'' +
                ", v=" + v +
                '}';
    }
}