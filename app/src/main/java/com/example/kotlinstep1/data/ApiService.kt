package com.example.kotlinstep1.data

import com.example.kotlinstep1.model.UsersModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("c81994a79cc5b3f96162")
   suspend fun getData():Response<UsersModel>
}

