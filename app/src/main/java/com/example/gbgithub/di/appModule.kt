package com.example.gbgithub.di

import com.example.gbgithub.data.datasource.mock.MockUsersRepoImpl
import com.example.gbgithub.data.datasource.web.GitHubApi
import com.example.gbgithub.data.datasource.web.RetrofitUsersRepoImpl
import com.example.gbgithub.data.repousecase.RepositoryUsecaseImpl
import com.example.gbgithub.domain.RepositoryUsecase
import com.example.gbgithub.domain.UserRepo
import com.example.gbgithub.ui.userdetail.UserDetailViewModel
import com.example.gbgithub.ui.userslist.UsersListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val MOCK_TYPE_SOURCE = "local_source"
private const val RETROFIT_TYPE_SOURCE = "web_source"

private enum class DataSourceType {
    MOCK,
    RETROFIT,
}

private val dataSourceType = DataSourceType.RETROFIT

val appModule = module {

    viewModel { UsersListViewModel(get()) }
    viewModel { UserDetailViewModel(get()) }

    single<RepositoryUsecase> { RepositoryUsecaseImpl(get((named(currentRepo())))) }

    single<UserRepo>(named(MOCK_TYPE_SOURCE)) { MockUsersRepoImpl() }
    single<UserRepo>(named(RETROFIT_TYPE_SOURCE)) { RetrofitUsersRepoImpl(get()) }
    single(named("api_url")) { "https://api.github.com/" }
    single<GitHubApi> { get<Retrofit>().create(GitHubApi::class.java) }
    single {
        Retrofit.Builder()
            .baseUrl(get<String>(named("api_url")))
            .addConverterFactory(get())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
    factory<Converter.Factory> { GsonConverterFactory.create() }
}

private fun currentRepo(): String {
    return when (dataSourceType) {
        DataSourceType.MOCK -> {
            MOCK_TYPE_SOURCE
        }
        DataSourceType.RETROFIT -> {
            RETROFIT_TYPE_SOURCE
        }
    }
}