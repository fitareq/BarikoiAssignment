package com.fitareq.barikoiassignment

import android.os.Bundle
import com.fitareq.barikoiassignment.databinding.ActivityMainBinding
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.camera.CameraPosition
import com.mapbox.mapboxsdk.geometry.LatLng

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Init MapLibre
        Mapbox.getInstance(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.map.getMapAsync { mapboxMap ->
            mapboxMap.setStyle("https://map.barikoi.com/styles/barikoi-bangla/style.json?key=bkoi_fc997801e71cdd71f51a0d5175702ea8a9653fd8e9df5fa0b0c954f81259f927")
            mapboxMap.cameraPosition =
                CameraPosition.Builder().target(LatLng(23.773184, 90.4003584)).zoom(10.0).build()
        }

    }

    override fun onStart() {
        super.onStart()
        binding.map.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.map.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.map.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.map.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.map.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.map.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.map.onSaveInstanceState(outState)
    }
}