package com.ozancanguz.todoapp.ui.fragments.add

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
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

        // set menu
        setHasOptionsMenu(true)


        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_fragment_menu,menu)
    }


}