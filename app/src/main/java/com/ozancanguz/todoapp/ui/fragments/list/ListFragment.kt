package com.ozancanguz.todoapp.ui.fragments.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ozancanguz.todoapp.R
import com.ozancanguz.todoapp.databinding.FragmentListBinding
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // set menu
        setHasOptionsMenu(true)

        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

         binding.floatingActionButton.setOnClickListener {
             findNavController().navigate(R.id.action_listFragment_to_addFragment)
         }

        binding.rowLayout.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_updateFragment)
        }




        return view
    }

    // init list fragment menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
         inflater.inflate(R.menu.list_fragment_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}