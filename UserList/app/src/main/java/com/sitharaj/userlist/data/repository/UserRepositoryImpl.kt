package com.sitharaj.userlist.data.repository


import com.sitharaj.userlist.data.mapper.toDomain
import com.sitharaj.userlist.data.remote.UserApi
import com.sitharaj.userlist.domain.model.User
import com.sitharaj.userlist.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        return api.getUsers().map { it.toDomain() }
    }
}
