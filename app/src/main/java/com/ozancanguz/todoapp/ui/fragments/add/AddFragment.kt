package com.ozancanguz.todoapp.ui.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ozancanguz.todoapp.R
import com.ozancanguz.todoapp.databinding.FragmentAddBinding
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

    private var _binding:FragmentAddBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root



        return view
    }


}