package com.fitareq.barikoiassignment.data.network

import com.fitareq.barikoiassignment.data.model.NearbyPlaces
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/nearby/category/{api_key}/2/20")
    suspend fun getNearbyBanks(
        @Path("api_key") apiKey: String,
        @Query("longitude") longitude: Double,
        @Query("latitude") latitude: Double,
        @Query("ptype") pType: String
    ): Response<NearbyPlaces>

}