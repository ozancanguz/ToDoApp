package com.ozancanguz.todoapp.ui.fragments.list

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ozancanguz.todoapp.R
import com.ozancanguz.todoapp.adapter.ListAdapter
import com.ozancanguz.todoapp.databinding.FragmentListBinding
import com.ozancanguz.todoapp.utils.SwipeToDelete
import com.ozancanguz.todoapp.viewmodels.ToDoViewModel
import kotlinx.android.synthetic.main.fragment_list.*
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
        binding.recyclerView.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.adapter=listAdapter
        swipeToDelete(binding.recyclerView)
    }

    // delete all menu onclick
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete_all){
            deleteAllItems()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllItems() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            viewModel.deleteAllItems()
            Toast.makeText(
                requireContext(),
                "Successfully Removed Everything!",
                Toast.LENGTH_SHORT
            ).show()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to remove everything?")
        builder.create().show()
    }

    //swipe to delete
    private fun swipeToDelete(recyclerView: RecyclerView) {

        val swipeToDeleteCallback=object : SwipeToDelete(){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val itemtoDelete=listAdapter.todolist[viewHolder.adapterPosition]
                viewModel.deleteSingleItem(itemtoDelete)
                Toast.makeText(requireContext(),"Removed successfully",Toast.LENGTH_LONG).show()


            }
        }
        val itemTouchHelper= ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }



}