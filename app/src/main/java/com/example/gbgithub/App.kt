package com.example.gbgithub

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.gbgithub.data.mock.MockUsersRepoImpl
import com.example.gbgithub.data.repousecase.RepositoryUsecaseImpl
import com.example.gbgithub.data.web.RetrofitUsersRepoImpl
import com.example.gbgithub.domain.UserRepo
import com.example.gbgithub.domain.RepositoryUsecase

class App : Application() {

    private val userRepo: UserRepo by lazy { RetrofitUsersRepoImpl() }
    val repositoryUsecase: RepositoryUsecase by lazy {
        RepositoryUsecaseImpl(app.userRepo)
    }
}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app
