package com.example.gbgithub.ui.userslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gbgithub.domain.RepositoryUsecase

class UsersListViewModelFactory(private val repositoryUsecase: RepositoryUsecase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersListViewModel(repositoryUsecase) as T
    }
}