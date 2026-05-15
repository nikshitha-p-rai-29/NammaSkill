package com.nammaskill.app.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.nammaskill.app.R
import com.nammaskill.app.data.model.SkillCenter
import com.nammaskill.app.databinding.FragmentMapBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapFragment : Fragment(), OnMapReadyCallback {
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    private var googleMap: GoogleMap? = null

    private val allCenters = listOf(
        SkillCenter(1, "PMKVY Center, Udupi", "Near Bus Stand, Udupi", "Udupi", "+91 94482 11001", 12, 1.2, "🏢", 13.3409, 74.7421),
        SkillCenter(2, "ITI Mangalore North", "Kadri Road, Mangalore", "Mangalore (DK)", "+91 94482 11002", 9, 8.4, "🏫", 12.9141, 74.8560),
        SkillCenter(3, "Skill India Hub, Kundapur", "Main Road, Kundapur", "Udupi", "+91 94482 11003", 7, 14.7, "🎓", 13.6278, 74.6910),
        SkillCenter(4, "Govt. Polytechnic, Udupi", "Polytechnic Road, Manipal", "Udupi", "+91 94482 11004", 15, 3.1, "🏛️", 13.3527, 74.7962),
        SkillCenter(5, "NSDC Partner Center, Karkala", "College Road, Karkala", "Udupi", "+91 94482 11005", 5, 22.0, "⚙️", 13.2050, 74.9978),
        SkillCenter(6, "Skill Center Shivamogga", "BH Road, Shivamogga", "Shivamogga", "+91 94482 11006", 4, 105.0, "🏭", 13.9299, 75.5681),
        SkillCenter(7, "Mysuru Vocational Institute", "JLB Road, Mysuru", "Mysuru", "+91 94482 11007", 8, 250.0, "🏗️", 12.2958, 76.6394)
    )

    private lateinit var adapter: CenterAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        setupRecyclerView()
        setupDistrictSpinner()
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        updateMarkers("All Districts")
    }

    private fun setupRecyclerView() {
        adapter = CenterAdapter { center ->
            Toast.makeText(requireContext(), "Calling ${center.name}...\n${center.phone}", Toast.LENGTH_SHORT).show()
            googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(center.latitude, center.longitude), 14f))
        }
        binding.rvCenters.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCenters.adapter = adapter
        updateList("All Districts")
    }

    private fun setupDistrictSpinner() {
        val districts = mutableListOf("All Districts")
        districts.addAll(resources.getStringArray(R.array.districts))

        val spinnerAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, districts)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerDistrictFilter.adapter = spinnerAdapter

        binding.spinnerDistrictFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selected = districts[position]
                updateList(selected)
                updateMarkers(selected)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun updateList(district: String) {
        val filtered = if (district == "All Districts") {
            allCenters
        } else {
            allCenters.filter { it.district.equals(district, ignoreCase = true) }
        }
        adapter.submitList(filtered)
        binding.tvCenterCount.text = "Showing ${filtered.size} centers in $district"
    }

    private fun updateMarkers(district: String) {
        val map = googleMap ?: return
        map.clear()
        
        val filtered = if (district == "All Districts") {
            allCenters
        } else {
            allCenters.filter { it.district.equals(district, ignoreCase = true) }
        }

        if (filtered.isNotEmpty()) {
            val first = filtered.first()
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(first.latitude, first.longitude), 10f))
        }

        filtered.forEach { center ->
            map.addMarker(
                MarkerOptions()
                    .position(LatLng(center.latitude, center.longitude))
                    .title(center.name)
                    .snippet(center.address)
            )
        }
    }

    override fun onDestroyView() { super.onDestroyView(); _binding = null }
}
