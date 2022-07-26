package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.view_models.ShoeListViewModel


class ShoeDetailFragment : Fragment() {

    lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        shoeListViewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        binding.shoe = Shoe("",0.0,"","")

        binding.cancelButton.setOnClickListener { view:View ->
            view.findNavController().popBackStack()
        }

        binding.saveButton.setOnClickListener { view:View ->

            val shoe: Shoe = binding.shoe as Shoe

            if(shoe.name.isEmpty() || shoe.company.isEmpty() || shoe.size == 0.0 || shoe.description.isEmpty()){
                Toast.makeText(context,"Please fill all fields",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            shoeListViewModel.addShoe(shoe)

            view.findNavController().popBackStack()
        }
        return binding.root
    }

}