package ru.eyelog.severalfragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Singleton

@Singleton
class AwesomeViewModel : ViewModel(){

    private val _titleLiveData = MutableLiveData<String>()
    val titleLiveData: LiveData<String> = _titleLiveData

    private var clickCounter = 0

    fun buttonClicked(){
        clickCounter++
        _titleLiveData.postValue("Button clicked $clickCounter раз")
    }
}