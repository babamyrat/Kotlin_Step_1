package com.example.kotlinstep1.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinstep1.domain.UserRepository
import com.example.kotlinstep1.model.UsersModel
import kotlinx.coroutines.launch
import retrofit2.Response


class UsersViewModel : ViewModel(){

    var repo = UserRepository()
    val myUserList: MutableLiveData<Response<UsersModel>> = MutableLiveData()

    //retrofit2 (Repository to ViewModel)
    fun getViewUsers() {
        viewModelScope.launch {
            myUserList.value = repo.getUserRepository()
        }
    }


}