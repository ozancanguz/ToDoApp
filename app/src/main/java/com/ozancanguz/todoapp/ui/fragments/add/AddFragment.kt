package com.ozancanguz.todoapp.ui.fragments.add

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ozancanguz.todoapp.R
import com.ozancanguz.todoapp.data.model.ToDo
import com.ozancanguz.todoapp.databinding.FragmentAddBinding
import com.ozancanguz.todoapp.viewmodels.ToDoViewModel


class AddFragment : Fragment() {

    private var _binding:FragmentAddBinding? = null
    private val binding get() = _binding!!
      private lateinit var viewmodel:ToDoViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val view = binding.root

        // set menu
        setHasOptionsMenu(true)

        // init viewmodel
        viewmodel=ViewModelProvider(this).get(ToDoViewModel::class.java)




        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_fragment_menu,menu)
    }



    // 2-menu onclick
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_add){
            insertToDb()
        }
        return super.onOptionsItemSelected(item)

    }

    // 1-insert database fun
    fun insertToDb(){
        val title=binding.titleEt.text.toString()
        val description=binding.descriptionEt.text.toString()

        var newData= ToDo(title,description)

        viewmodel.insertData(newData)
        Toast.makeText(requireContext(),"Data added to db",Toast.LENGTH_LONG).show()

        // navigate back to list fragment
        findNavController().navigate(R.id.action_addFragment_to_listFragment)

    }


}