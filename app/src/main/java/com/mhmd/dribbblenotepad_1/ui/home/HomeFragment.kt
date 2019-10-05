package com.mhmd.dribbblenotepad_1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mhmd.dribbblenotepad_1.MainActivity
import com.mhmd.dribbblenotepad_1.R
import com.mhmd.dribbblenotepad_1.data.Note
import com.mhmd.dribbblenotepad_1.data.NoteDatabase
import com.mhmd.dribbblenotepad_1.ui.NoteAdapter
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {
    
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var list: LiveData<List<Note>>
//    private lateinit var list: List<Note>
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        
        val dateTextView: TextView = root.findViewById(R.id.home_date)
        dateTextView.text = SimpleDateFormat("MMM - dd", Locale.getDefault()).format(Date())
        
        val calendar = Calendar.getInstance()
        val weekDayTextView: TextView = root.findViewById(R.id.home_week_day)
        weekDayTextView.text =
            calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())
        
        val imageMenu: ImageView = root.findViewById(R.id.image_menu)
        imageMenu.setOnClickListener {
            (activity as MainActivity).openDrawer()
        }
        
        val fab: FloatingActionButton = root.findViewById(R.id.fab_new_note)
        fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.go_to_note))
        
        
        val database = NoteDatabase.INSTANCE
        val adapter = NoteAdapter()
        
        list = database!!.noteDao().getAll()
        list.observe(this, androidx.lifecycle.Observer {
            adapter.setData(it)
        })
        
        val recyclerview: RecyclerView = root.findViewById(R.id.home_recycler)
        recyclerview.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerview.adapter = adapter


        val callback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN
            , ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                database.noteDao().delete(adapter.getNoteAt(viewHolder.adapterPosition))
                adapter.notifyDataSetChanged()
            }

        }

        val helper = ItemTouchHelper(callback)
        helper.attachToRecyclerView(recyclerview)
        
        
        return root
    }
}