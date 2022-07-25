package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.login.setOnClickListener{view:View ->
            view.findNavController().navigate(R.id.action_login_fragment_to_welcome)
        }

        binding.createAccount.setOnClickListener{view:View ->
            view.findNavController().navigate(R.id.action_login_fragment_to_welcome)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            requireActivity().finish()
        }
        return binding.root
    }


}