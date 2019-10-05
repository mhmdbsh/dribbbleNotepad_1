package com.mhmd.dribbblenotepad_1.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mhmd.dribbblenotepad_1.R
import com.mhmd.dribbblenotepad_1.data.Note

//class NoteAdapter(private val noteList: List<Note>) :
class NoteAdapter() :
    
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    
    private lateinit var noteList: List<Note>
    
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
            
            date.text = note.date
            title.text = note.title
            body.text = note.body
            when (note.color) {
                0 -> ribbon.setImageResource(R.drawable.rectangle_black)
                1 -> ribbon.setImageResource(R.color.colorRed)
                2 -> ribbon.setImageResource(R.color.colorBlue)
                3 -> ribbon.setImageResource(R.color.colorGreen)
                4 -> ribbon.setImageResource(R.color.colorYellow)
            }
        }
    }
    
    fun getNoteAt(position: Int): Note {
        return noteList[position]
    }
    
    fun setData(noteList: List<Note>) {
        this.noteList = noteList
        notifyDataSetChanged()
    }
    
}