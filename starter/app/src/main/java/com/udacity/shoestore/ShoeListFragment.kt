package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.view_models.ShoeListViewModel
import kotlinx.android.synthetic.main.shoe_item.view.*
import timber.log.Timber

class ShoeListFragment : Fragment() {

    lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        shoeListViewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        setHasOptionsMenu(true)
        binding.addFab.setOnClickListener{ view ->
           view.findNavController().navigate(R.id.shoeDetailFragment)
        }



        shoeListViewModel.shoesList.observe(viewLifecycleOwner, Observer {shoeList ->
            addShoeItems(shoeList,binding)
        })

        return binding.root
    }

    private fun addShoeItems(shoeList: ArrayList<Shoe>, binding: FragmentShoeListBinding) {

        for(shoe in shoeList){
            var shoe_item: View = View.inflate(activity,R.layout.shoe_item, null)
            shoe_item.shoe_name_item.text = "Name: " + shoe.name;
            shoe_item.shoe_company_item.text = "Company: " + shoe.company;
            shoe_item.shoe_size_item.text = "Size: " + shoe.size.toString();
            shoe_item.shoe_desc_item.text = "Description: " + shoe.description
            binding.shoeListLinearLayout.addView(shoe_item)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        return inflater.inflate(R.menu.menu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = this.findNavController()
        return NavigationUI.onNavDestinationSelected(item,navController) || super.onOptionsItemSelected(item)
    }



}