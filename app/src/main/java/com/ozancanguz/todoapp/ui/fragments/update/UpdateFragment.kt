package com.ozancanguz.todoapp.ui.fragments.update

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ozancanguz.todoapp.R
import com.ozancanguz.todoapp.data.model.ToDo
import com.ozancanguz.todoapp.databinding.FragmentUpdateBinding
import com.ozancanguz.todoapp.viewmodels.ToDoViewModel


class UpdateFragment : Fragment() {

    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!

    // init args
    private val args:UpdateFragmentArgs by navArgs()

    //init viewmodel
    private val viewmodel:ToDoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)
        val view = binding.root

        // set menu
        setHasOptionsMenu(true)

        // get result from list fragment
        getArgsFromList()

   return view
    }

    // get args fun
      fun getArgsFromList(){
          binding.currentDescriptionEt.setText(args.result.description)
          binding.currentTitleEt.setText(args.result.title)
      }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_fragment_menu,menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    // save menu onclick listener
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_save){
            updateItem()
        }
        return super.onOptionsItemSelected(item)
    }

    // update item fun
    fun updateItem(){
        val title=binding.currentTitleEt.text.toString()
        val description=binding.currentDescriptionEt.text.toString()

        val updatedItem=ToDo(args.result.id,title,description)

        // data updated in fragment list
        viewmodel.updateData(updatedItem)
        Toast.makeText(requireContext(),"item updated",Toast.LENGTH_LONG).show()

      // navigate to fragment list
      findNavController().navigate(R.id.action_updateFragment_to_listFragment)


    }




}