package com.example.kotlinstep1.domain

import com.example.kotlinstep1.data.ApiClient
import com.example.kotlinstep1.model.UsersModel
import retrofit2.Response

class UserRepository {

    suspend fun getUserRepository() : Response<UsersModel> {
        return ApiClient.api.getData()
    }



}