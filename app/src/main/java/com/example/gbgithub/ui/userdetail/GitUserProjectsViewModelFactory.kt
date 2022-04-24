package com.example.gbgithub.ui.userdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gbgithub.domain.GitUserProjectsList

class GitUserProjectsViewModelFactory(private val repo: GitUserProjectsList) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserDetailViewModel(repo) as T
    }
}