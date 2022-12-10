package com.ozancanguz.todoapp.ui.fragments.update

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ozancanguz.todoapp.R
import com.ozancanguz.todoapp.databinding.FragmentUpdateBinding



class UpdateFragment : Fragment() {

    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!

    // init args
    private val args:UpdateFragmentArgs by navArgs()

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_fragment_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

      fun getArgsFromList(){
          binding.currentDescriptionEt.setText(args.result.description)
          binding.currentTitleEt.setText(args.result.title)
      }




}