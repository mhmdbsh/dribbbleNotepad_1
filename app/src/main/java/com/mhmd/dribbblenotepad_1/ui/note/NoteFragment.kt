package com.mhmd.dribbblenotepad_1.ui.note

import android.animation.Animator
import android.os.Bundle
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.animation.doOnEnd
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mhmd.dribbblenotepad_1.R
import kotlinx.android.synthetic.main.fragment_note.*
import kotlinx.coroutines.handleExceptionViaHandler
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.max

class NoteFragment : Fragment() {
    
    
    private var noteColor = colors.WHITE
    private var location = IntArray(2)
    private var centerX = 0
    private var centerY = 0
    private var isBlack = true
    private lateinit var fadeOutAnimation: Animation
    private lateinit var fadeInAnimation: Animation
    
    private lateinit var tableRow: TableRow
    private lateinit var title: EditText
    private lateinit var body: EditText
    private lateinit var textDate: TextView
    private lateinit var background: ImageView
    private lateinit var ovalBlue: ImageView
    private lateinit var ovalRed: ImageView
    private lateinit var ovalWhite: ImageView
    private lateinit var ovalYellow: ImageView
    private lateinit var ovalGreen: ImageView
    private lateinit var imageBack: ImageView
    private lateinit var window: FrameLayout
    private lateinit var topArea: ConstraintLayout
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_note, container, false)
        
        val date = SimpleDateFormat("MMM - dd", Locale.getDefault()).format(Date())
        
        background = root.findViewById(R.id.image_background)
        textDate = root.findViewById(R.id.text_date)
        title = root.findViewById(R.id.text_title)
        body = root.findViewById(R.id.text_body)
        ovalBlue = root.findViewById(R.id.oval_blue)
        ovalRed = root.findViewById(R.id.oval_red)
        ovalWhite = root.findViewById(R.id.oval_white)
        ovalYellow = root.findViewById(R.id.oval_yellow)
        ovalGreen = root.findViewById(R.id.oval_green)
        imageBack = root.findViewById(R.id.image_back)
        window = root.findViewById(R.id.note_container)
        topArea = root.findViewById(R.id.note_top_area)
        
        fadeInAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        fadeOutAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_out)
        
        textDate.text = date
        
        ovalRed.setOnClickListener {
            noteColor = colors.RED
            isBlack = false
            ovalRed.getLocationOnScreen(location)
            reveal(ovalRed, background)
            setElementsColor()
        }
        ovalGreen.setOnClickListener {
            noteColor = colors.GREEN
            isBlack = false
            ovalGreen.getLocationOnScreen(location)
            reveal(ovalGreen, background)
            setElementsColor()
        }
        ovalYellow.setOnClickListener {
            noteColor = colors.YELLOW
            isBlack = true
            ovalYellow.getLocationOnScreen(location)
            reveal(ovalYellow, background)
            setElementsColor()
        }
        ovalBlue.setOnClickListener {
            noteColor = colors.BLUE
            isBlack = false
            ovalBlue.getLocationOnScreen(location)
            reveal(ovalBlue, background)
            setElementsColor()
        }
        ovalWhite.setOnClickListener {
            noteColor = colors.WHITE
            isBlack = true
            ovalWhite.getLocationOnScreen(location)
            reveal(ovalWhite, background)
            setElementsColor()
        }
        
        imageBack.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.go_to_home))
        
        return root
    }
    
    private fun setElementsColor() {
        topArea.startAnimation(fadeInAnimation)
        if (!isBlack) {
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
    
    fun reveal(oval: ImageView, background: ImageView) {
        
        centerX = location[0] + ovalWhite.width / 2
        centerY = location[1] - ovalWhite.height / 4
        
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
            }
            R.id.oval_red -> {
                color = R.color.colorRed
                ring_red.visibility = View.VISIBLE
            }
            R.id.oval_green -> {
                color = R.color.colorGreen
                ring_green.visibility = View.VISIBLE
                
            }
            R.id.oval_yellow -> {
                color = R.color.colorYellow
                ring_yellow.visibility = View.VISIBLE
            }
            R.id.oval_white -> {
                color = R.color.colorWhite
                ring_white.visibility = View.VISIBLE
            }
        }
        background.setImageResource(color)
        val reveal: Animator =
            ViewAnimationUtils.createCircularReveal(background, centerX, centerY, 0f, radius)
        reveal.doOnEnd {
            note_container.setBackgroundColor(resources.getColor(color))
        }
        reveal.duration = 500
        reveal.start()
        
    }
    
}

enum class colors {
    WHITE, RED, BLUE, GREEN, YELLOW
}