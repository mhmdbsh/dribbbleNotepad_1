package com.mhmd.dribbblenotepad_1.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mhmd.dribbblenotepad_1.R
import com.mhmd.dribbblenotepad_1.data.Note

class NoteAdapter(val noteList: ArrayList<Note>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.note_list_row, parent, false)
        
        return NoteViewHolder(view)
        
    }
    
    override fun getItemCount(): Int {
        
        return noteList.size
    }
    
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        
        holder.bindItem(noteList[position])
    }
    
    
    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        
        fun bindItem(note: Note) {
            val date: TextView = itemView.findViewById(R.id.recycler_textView_time)
            val title: TextView = itemView.findViewById(R.id.recycler_textView_title)
            val body: TextView = itemView.findViewById(R.id.recycler_textView_body)
            val ribbon: ImageView = itemView.findViewById(R.id.recycler_imageView_ribbon)
        }
    }
    
}