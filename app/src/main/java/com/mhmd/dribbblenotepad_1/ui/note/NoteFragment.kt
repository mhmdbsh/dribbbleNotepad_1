package com.mhmd.dribbblenotepad_1.ui.note

import android.animation.Animator
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mhmd.dribbblenotepad_1.R
import kotlinx.android.synthetic.main.fragment_note.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.max

class NoteFragment : Fragment() {
    
    
    var noteColor = colors.WHITE
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_note, container, false)
        
        val date = SimpleDateFormat("MMM - dd", Locale.getDefault()).format(Date())
        
        val background: ImageView = root.findViewById(R.id.image_background)
        val noteContainer: ConstraintLayout = root.findViewById(R.id.note_container)
        val textDate: TextView = root.findViewById(R.id.text_date)
        val title: EditText = root.findViewById(R.id.text_title)
        val body: EditText = root.findViewById(R.id.text_body)
        val ovalBlue: ImageView = root.findViewById(R.id.oval_blue)
        val ovalRed: ImageView = root.findViewById(R.id.oval_red)
        val ovalWhite: ImageView = root.findViewById(R.id.oval_white)
        val ovalYellow: ImageView = root.findViewById(R.id.oval_yellow)
        val ovalGreen: ImageView = root.findViewById(R.id.oval_green)
        val imageBack: ImageView = root.findViewById(R.id.image_back)
        
        
        textDate.text = date
        
        ovalRed.setOnClickListener {
            noteColor = colors.RED
            reveal(ovalRed, background, noteContainer)
            setElementsColor(
                textDate,
                title,
                body,
                resources.getColor(R.color.colorWhite),
                imageBack
            )
        }
        ovalGreen.setOnClickListener {
            noteColor = colors.GREEN
            reveal(ovalGreen, background, noteContainer)
            setElementsColor(
                textDate,
                title,
                body,
                resources.getColor(R.color.colorWhite),
                imageBack
            )
            
        }
        ovalYellow.setOnClickListener {
            noteColor = colors.YELLOW
            reveal(ovalYellow, background, noteContainer)
            setElementsColor(
                textDate,
                title,
                body,
                resources.getColor(R.color.colorBlack),
                imageBack
            )
            
        }
        ovalBlue.setOnClickListener {
            noteColor = colors.BLUE
            reveal(ovalBlue, background, noteContainer)
            setElementsColor(
                textDate,
                title,
                body,
                resources.getColor(R.color.colorWhite),
                imageBack
            )
        }
        
        ovalWhite.setOnClickListener{
            noteColor = colors.WHITE
            reveal(ovalWhite, background, noteContainer)
            setElementsColor(
                textDate,
                title,
                body,
                resources.getColor(R.color.colorBlack),
                imageBack
            )
        }
        
        imageBack.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.go_to_home))
        
        return root
    }
    
    private fun setElementsColor(
        textDate: TextView, title: EditText, body: EditText, color: Int
        , imageBack: ImageView
    ) {
        if (color == resources.getColor(R.color.colorWhite)) {
            textDate.setTextColor(resources.getColor(R.color.colorWhite))
            title.setTextColor(resources.getColor(R.color.colorWhite))
            title.setHintTextColor(resources.getColor(R.color.colorWhite))
            body.setTextColor(resources.getColor(R.color.colorWhite))
            body.setHintTextColor(resources.getColor(R.color.colorWhite))
            imageBack.setImageResource(R.drawable.ic_arrow_left_white)
        } else {
            textDate.setTextColor(resources.getColor(R.color.colorBlack))
            title.setTextColor(resources.getColor(R.color.colorBlack))
            title.setHintTextColor(resources.getColor(R.color.colorBlack))
            body.setTextColor(resources.getColor(R.color.colorBlack))
            body.setHintTextColor(resources.getColor(R.color.colorBlack))
            imageBack.setImageResource(R.drawable.ic_arrow_left_black)
        }
        
    }
    
    fun reveal(oval: ImageView, background: ImageView, container: ConstraintLayout) {
        
        var centerX = background.right
        var centerY = background.bottom
        val radius = max(background.width, background.height) * 2.0f
        var color: Int = R.color.colorWhite
        
        ring_blue.visibility = View.INVISIBLE
        ring_green.visibility = View.INVISIBLE
        ring_red.visibility = View.INVISIBLE
        ring_yellow.visibility = View.INVISIBLE
        ring_white.visibility = View.INVISIBLE
        
        when (oval.id) {
            R.id.oval_blue -> {
                color = R.color.colorBlue
                ring_blue.visibility = View.VISIBLE
                centerX = background.right - 190
                centerY = background.bottom - 85
            }
            R.id.oval_red -> {
                color = R.color.colorRed
                ring_red.visibility = View.VISIBLE
                centerX = background.right - 295
                centerY = background.bottom - 85
            }
            R.id.oval_green -> {
                color = R.color.colorGreen
                ring_green.visibility = View.VISIBLE
                centerX = background.right - 400
                centerY = background.bottom - 85
            }
            R.id.oval_yellow -> {
                color = R.color.colorYellow
                ring_yellow.visibility = View.VISIBLE
                centerX = background.right - 505
                centerY = background.bottom - 85
            }
            R.id.oval_white -> {
                color = R.color.colorWhite
                ring_white.visibility = View.VISIBLE
                centerX = background.right - 85
                centerY = background.bottom - 85
            }
        }
        background.setImageResource(color)
        val reveal: Animator =
            ViewAnimationUtils.createCircularReveal(background, centerX, centerY, 0f, radius)
        reveal.doOnEnd {
            note_container.setBackgroundColor(resources.getColor(color))
        }
        reveal.start()
    }
}

enum class colors {
    WHITE, RED, BLUE, GREEN, YELLOW
}