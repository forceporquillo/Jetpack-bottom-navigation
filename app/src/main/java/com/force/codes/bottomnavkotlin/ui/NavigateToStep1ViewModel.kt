package com.force.codes.bottomnavkotlin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavigateToStep1ViewModel : ViewModel(){
    private val _textTitle = MutableLiveData<String>().apply {
        value = "Navigate to Step 2 Fragment"
    }

    val text: LiveData<String> = _textTitle
}