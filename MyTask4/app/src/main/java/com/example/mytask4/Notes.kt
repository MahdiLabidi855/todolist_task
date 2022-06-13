package com.example.mytask4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytask4.Nots
import com.example.mytask4.notsadapter
import com.example.task4.databinding.ActivityNotesBinding
import com.example.task4.databinding.ItemNotesBinding

class notes : Fragment() {
    private lateinit var binding: ActivityNotesBinding
    private lateinit var bindingitem: ItemNotesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ActivityNotesBinding.inflate(inflater,container,false)
        val view = binding.root
        val NotesListSingleItem = mutableListOf(
            Nots("task",false,"first Notes"),
        )
        val adapter = notsadapter(NotesListSingleItem)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(activity)


        binding.btnAddTodo.setOnClickListener {

            val newTodoTitle = binding.etAddTodo.text.toString()
            val newNotes = binding.etAddNotes.text.toString()
            val newTodo =  Nots(newTodoTitle,false,newNotes)

            NotesListSingleItem.add(newTodo)
            adapter.notifyDataSetChanged()
            binding.etAddTodo.text.clear()
        }

        return view
    }
}