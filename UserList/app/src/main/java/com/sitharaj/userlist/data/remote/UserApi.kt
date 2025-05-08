package com.sitharaj.userlist.data.remote

import com.sitharaj.userlist.data.remote.dto.UserDto
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUsers(): List<UserDto>
}