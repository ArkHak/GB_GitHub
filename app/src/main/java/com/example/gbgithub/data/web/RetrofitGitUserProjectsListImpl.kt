package com.example.gbgithub.data.web

import com.example.gbgithub.domain.GitUserProjectsList
import com.example.gbgithub.domain.dto.GitProjectDto
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL_API_GITHUB = "https://api.github.com/"

class RetrofitGitUserProjectsListImpl : GitUserProjectsList {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_API_GITHUB)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
    private val api: GitHubApi = retrofit.create(GitHubApi::class.java)

    override fun observeGitUserProjectsList(username: String): Single<List<GitProjectDto>> {
        return api.listUserProjects(username)
    }
}