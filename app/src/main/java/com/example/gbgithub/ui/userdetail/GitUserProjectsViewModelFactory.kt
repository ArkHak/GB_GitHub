package com.example.gbgithub.ui.userdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gbgithub.domain.RepositoryUsecase

class GitUserProjectsViewModelFactory(private val repositoryUsecase: RepositoryUsecase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserDetailViewModel(repositoryUsecase) as T
    }
}