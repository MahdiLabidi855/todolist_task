package com.example.mytask4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task4.databinding.ItemNotesBinding

class notsadapter (var Notes:List<Nots>) : RecyclerView.Adapter<notsadapter.NoteViewHolder>(){
inner class NoteViewHolder(val binding: ItemNotesBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
return NoteViewHolder(ItemNotesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.binding.apply {
            tvtitle.text = Notes[position].title
            chknote.isChecked =Notes[position].ischecked
            tvnotes.text = Notes[position].textnotes
        }
    }

    override fun getItemCount(): Int {
        return  Notes.size
    }
}