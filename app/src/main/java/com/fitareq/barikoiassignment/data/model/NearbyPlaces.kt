package com.fitareq.barikoiassignment.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NearbyPlaces(
    @SerializedName("places")
    @Expose
    var places: ArrayList<Places>
)

data class Places(

    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("distance_in_meters")
    @Expose
    var distanceInMeters: String,
    @SerializedName("longitude")
    @Expose
    var longitude: String,
    @SerializedName("latitude")
    @Expose
    var latitude: String,
    @SerializedName("city")
    @Expose
    var city: String,
    @SerializedName("area")
    @Expose
    var area: String,
    @SerializedName("ST_AsText(location)")
    @Expose
    var STAsText: String,
    @SerializedName("pType")
    @Expose
    var pType: String,
    @SerializedName("subType")
    @Expose
    var subType: String,
    @SerializedName("postCode")
    @Expose
    var postCode: String,
    @SerializedName("Address")
    @Expose
    var Address: String,
    @SerializedName("uCode")
    @Expose
    var uCode: String

)
