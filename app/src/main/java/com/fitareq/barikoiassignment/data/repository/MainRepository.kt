package com.fitareq.barikoiassignment.data.repository

import com.fitareq.barikoiassignment.data.model.NearbyPlaces
import com.fitareq.barikoiassignment.data.network.Api
import com.fitareq.barikoiassignment.ui.UiState
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: Api
) {
    companion object {
        const val apiKey = "bkoi_fc997801e71cdd71f51a0d5175702ea8a9653fd8e9df5fa0b0c954f81259f927"
    }

    suspend fun getNearbyBanks(longitude: Double, latitude: Double): UiState<NearbyPlaces> {
        return try {
            val response = api.getNearbyBanks(apiKey, longitude, latitude, "bank")
            if (response.code() == 200 && response.body() != null) {
                UiState.Success(response.body()!!)
            } else {
                UiState.Error(response.message())
            }
        } catch (e: Exception) {
            UiState.Error(e.message ?: "Something went wrong")
        }

    }
}