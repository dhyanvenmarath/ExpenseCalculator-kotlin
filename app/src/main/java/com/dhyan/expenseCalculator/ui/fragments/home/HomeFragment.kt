package com.dhyan.expenseCalculator.ui.fragments.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController
import com.dhyan.expenseCalculator.R

import com.dhyan.expenseCalculator.databinding.FragmentHomeBinding



class HomeFragment : Fragment(R.layout.fragment_home) {
    lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container:ViewGroup?,
        savedInstanceState:Bundle?
    ): View {
        _binding=FragmentHomeBinding.inflate(inflater,container,false)
        val view=binding.root
        //viewModel=(activity as HomeViewModel).viewModel
        binding.IdHomeAutoBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_autoFragment)
        }
        binding.IdHomeShopBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_shopFragment)
        }
        binding.IdHomeMedicineBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_medicineFragment)
        }
        binding.IdHomeDoctorBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_doctorFragment)
        }
        binding.IdHomeLabBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_labFragment)
        }
        binding.IdHomeCreditBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_creditFragment)
        }
        binding.IdHomeHospitalBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_hospitalFragment)
        }
        return view


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}