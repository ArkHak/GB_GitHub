package com.example.gbgithub.data.retrofit

import com.example.gbgithub.domain.entitys.GitProjectEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("users/{user}/repos")
    fun listUserProjects(@Path("user") user: String?): Single<List<GitProjectEntity>>
}