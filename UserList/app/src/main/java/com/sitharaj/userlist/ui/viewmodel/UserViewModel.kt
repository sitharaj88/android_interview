package com.sitharaj.userlist.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sitharaj.userlist.domain.model.User
import com.sitharaj.userlist.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            _loading.value = true
            runCatching {
                getUsersUseCase()
            }.onSuccess {
                _users.value = it
            }.also {
                _loading.value = false
            }
        }
    }
}

