package com.ozancanguz.todoapp.ui.fragments.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ozancanguz.todoapp.R
import com.ozancanguz.todoapp.adapter.ListAdapter
import com.ozancanguz.todoapp.databinding.FragmentListBinding
import com.ozancanguz.todoapp.viewmodels.ToDoViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val listAdapter=ListAdapter()

    //init viewmodel
    private val viewModel:ToDoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root


        // set menu
        setHasOptionsMenu(true)

        // init rv
        initRv()

        // observeLiveData()
        observeLiveData()


         binding.floatingActionButton.setOnClickListener {
             findNavController().navigate(R.id.action_listFragment_to_addFragment)
         }

        binding.rowLayout.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_updateFragment)
        }




        return view
    }

    // observe and update ui
    private fun observeLiveData() {
        viewModel.getAllData.observe(viewLifecycleOwner, Observer { data->
             listAdapter.updateData(data)
        })

    }

    // init list fragment menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
         inflater.inflate(R.menu.list_fragment_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    // init rv
    fun initRv(){
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=listAdapter
    }


}