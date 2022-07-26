package com.udacity.shoestore.view_models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {

    private val _shoesList: MutableLiveData<ArrayList<Shoe>> = MutableLiveData<ArrayList<Shoe>>()

    val shoesList: LiveData<ArrayList<Shoe>>
        get() = _shoesList

    init {
        _shoesList.value = ArrayList<Shoe>()
       _shoesList.value?.add(Shoe("Nike 33", 60.0, "Nike","Sports shoe for running"))
    }

    fun addShoe(shoe: Shoe){
        _shoesList.value?.add(shoe)
    }

}