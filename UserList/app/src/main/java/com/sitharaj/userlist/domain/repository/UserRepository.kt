package com.sitharaj.userlist.domain.repository

import com.sitharaj.userlist.domain.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}