package com.example.gbgithub

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.gbgithub.data.mock.MockUsersRepoImpl
import com.example.gbgithub.data.repousecase.RepositoryUsecaseImpl
import com.example.gbgithub.data.web.RetrofitUsersRepoImpl
import com.example.gbgithub.domain.UserRepo
import com.example.gbgithub.domain.RepositoryUsecase


private enum class DataSourceType {
    MOCK,
    WEB,
}

private val dataSourceType = DataSourceType.WEB

class App : Application() {

    private val localUserRepo: UserRepo by lazy { MockUsersRepoImpl() }
    private val webUserRepo: UserRepo by lazy { RetrofitUsersRepoImpl() }

    private val userRepo: UserRepo by lazy { currentRepo() }

    val repositoryUsecase: RepositoryUsecase by lazy {
        RepositoryUsecaseImpl(app.userRepo)
    }

    private fun currentRepo(): UserRepo {
        return when (dataSourceType) {
            DataSourceType.MOCK -> {
                localUserRepo
            }
            DataSourceType.WEB -> {
                webUserRepo
            }
        }
    }
}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app
