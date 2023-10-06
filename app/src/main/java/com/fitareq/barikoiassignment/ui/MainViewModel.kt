package com.fitareq.barikoiassignment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fitareq.barikoiassignment.data.model.NearbyPlaces
import com.fitareq.barikoiassignment.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {
    private val _banks = MutableLiveData<UiState<NearbyPlaces>>()
     val banks: LiveData<UiState<NearbyPlaces>> = _banks

    fun getNearbyBanks(longitude: Double, latitude: Double) {
        _banks.postValue(UiState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            repository.getNearbyBanks(longitude, latitude).let {
                _banks.postValue(it)
            }
        }
    }
}