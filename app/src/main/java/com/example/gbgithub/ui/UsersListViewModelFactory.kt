package com.example.gbgithub.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gbgithub.domain.GitUsersRepo

class UsersListViewModelFactory(private val usersList: GitUsersRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersListViewModel(usersList) as T
    }
}