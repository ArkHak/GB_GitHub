package com.example.gbgithub.di

import com.example.gbgithub.data.datasource.mock.MockUsersRepoImpl
import com.example.gbgithub.data.datasource.web.GitHubApi
import com.example.gbgithub.data.datasource.web.RetrofitUsersRepoImpl
import com.example.gbgithub.data.repousecase.RepositoryUsecaseImpl
import com.example.gbgithub.domain.RepositoryUsecase
import com.example.gbgithub.domain.UserRepo
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

private const val MOCK_TYPE_SOURCE = "local_source"
private const val RETROFIT_TYPE_SOURCE = "web_source"

private const val CORRECT_DATA_SOURCE_TYPE = MOCK_TYPE_SOURCE

@Module
class AppDependenciesModuleDagger {
    @Provides
    fun provideDataSource(@Named(CORRECT_DATA_SOURCE_TYPE) userRepo: UserRepo): RepositoryUsecase {
        return RepositoryUsecaseImpl(userRepo)
    }

    @Singleton
    @Provides
    @Named(RETROFIT_TYPE_SOURCE)
    fun provideUserRepoRetrofit(gitHubApi: GitHubApi): UserRepo {
        return RetrofitUsersRepoImpl(gitHubApi)
    }

    @Singleton
    @Provides
    @Named(MOCK_TYPE_SOURCE)
    fun provideUserRepoMock(): UserRepo {
        return MockUsersRepoImpl()
    }

    @Singleton
    @Provides
    fun provideGitHubApi(retrofit: Retrofit): GitHubApi {
        return retrofit.create(GitHubApi::class.java)
    }

    @Provides
    fun provideBaseUrl(): String {
        return "https://api.github.com/"
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun providerRetrofit(baseUrl: String, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }
}
