package com.ozancanguz.todoapp.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.todoapp.R
import com.ozancanguz.todoapp.data.model.ToDo
import com.ozancanguz.todoapp.ui.fragments.list.ListFragmentDirections
import kotlinx.android.synthetic.main.list_row_layout.view.*

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    var todolist= emptyList<ToDo>()


    // update ui
     fun updateData(newData:List<ToDo>){
         this.todolist=newData
        notifyDataSetChanged()
     }

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.list_row_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem=todolist[position]
        holder.itemView.title_txt.text=currentItem.title
        holder.itemView.description_txt.text=currentItem.description


        holder.itemView.setOnClickListener {
            val directions=ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(directions)

        }





    }

    override fun getItemCount(): Int {
        return todolist.size
    }


}