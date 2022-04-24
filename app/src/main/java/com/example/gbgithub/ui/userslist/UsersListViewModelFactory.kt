package com.example.gbgithub.ui.userslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gbgithub.domain.GitUsersList

class UsersListViewModelFactory(private val usersList: GitUsersList) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersListViewModel(usersList) as T
    }
}