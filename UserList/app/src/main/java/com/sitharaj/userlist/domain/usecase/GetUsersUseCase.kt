package com.sitharaj.userlist.domain.usecase

import com.sitharaj.userlist.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke() = repository.getUsers()
}
