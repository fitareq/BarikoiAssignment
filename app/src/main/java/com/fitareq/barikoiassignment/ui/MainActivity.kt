package com.fitareq.barikoiassignment.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.fitareq.barikoiassignment.BaseActivity
import com.fitareq.barikoiassignment.data.model.Places
import com.fitareq.barikoiassignment.databinding.ActivityMainBinding
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapboxMap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var map: MapboxMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Init MapLibre
        Mapbox.getInstance(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.banks.observe(this) {
            when (it) {
                is UiState.Loading -> {
                    showLoadingScreen()
                }

                is UiState.Success -> {
                    addMarkersToMap(it.data.places)
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                    hideLoadingScreen()
                }

                is UiState.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    hideLoadingScreen()
                }
            }
        }
        binding.mapView.getMapAsync { mapboxMap ->
            map = mapboxMap
            map.setStyle("https://map.barikoi.com/styles/barikoi-bangla/style.json?key=bkoi_fc997801e71cdd71f51a0d5175702ea8a9653fd8e9df5fa0b0c954f81259f927")
            map.cameraPosition =
                CameraPosition.Builder().target(LatLng(23.773184, 90.4003584)).zoom(15.0).build()
            viewModel.getNearbyBanks(90.4003584, 23.773184)
        }

    }

    private fun addMarkersToMap(banks: ArrayList<Places>) {
        banks.forEach {bank->
            val latLng = LatLng(bank.latitude.toDouble(), bank.longitude.toDouble())

            val title = bank.name
            val snippet = "Distance: ${String.format("%.2f", bank.distanceInMeters.toDouble())} meter\n${bank.Address}"

            val markerOption = MarkerOptions()
                .position(latLng)
                .title(title)
                .snippet(snippet)

            map.addMarker(markerOption)

        }
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }
}