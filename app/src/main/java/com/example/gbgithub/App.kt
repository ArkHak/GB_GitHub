package com.example.gbgithub

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.gbgithub.data.MockGitUsersListImpl
import com.example.gbgithub.data.RetrofitGitUserProjectsListImpl
import com.example.gbgithub.domain.GitUserProjectsList
import com.example.gbgithub.domain.GitUsersList

class App : Application() {
    val gitUsersList: GitUsersList by lazy { MockGitUsersListImpl() }
    val gitProjectRepoList: GitUserProjectsList by lazy { RetrofitGitUserProjectsListImpl() }
}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app
