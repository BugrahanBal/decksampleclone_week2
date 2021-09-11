package com.balbugrahan.decksampleclone.ui
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    //We created mutableLive Data for data transfer Fragment to Fragment
    private val mutableLiveDataQuestion: MutableLiveData<String> = MutableLiveData()
    private val mutableLiveDataAnswers : MutableLiveData<Bundle> = MutableLiveData()
    //We are setting data in Fragment Welcome via MutableLiveData
    fun setDataQuestion(input: String) { mutableLiveDataQuestion.value = input }
    fun setDataAnswers(Arrays: Bundle){ mutableLiveDataAnswers.value= Arrays}
    //We are getting data in Fragment Quiz via MutableLiveData
    fun getDataQuestion(): MutableLiveData<String> = mutableLiveDataQuestion
    fun getDataAnswers(): MutableLiveData<Bundle> = mutableLiveDataAnswers
}