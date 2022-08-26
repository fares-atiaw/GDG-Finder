package com.example.android.gdgfinder.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class VM_Home : ViewModel()
{
    private val _navigateToSearch = MutableLiveData<Boolean>()
    val navigateToSearch: LiveData<Boolean>
        get() = _navigateToSearch

    fun onFabClicked() {
        _navigateToSearch.value = true
    }

    fun navigationDone_ToSearch() {
        _navigateToSearch.value = false
    }
}