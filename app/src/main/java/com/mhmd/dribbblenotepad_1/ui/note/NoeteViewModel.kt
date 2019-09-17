package com.mhmd.dribbblenotepad_1.ui.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NoeteViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        
        value = "this is note fragment"
    }
    val text: LiveData<String> = _text
}