package com.example.gbgithub.data.web

import com.example.gbgithub.domain.dto.GitProjectDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("users/{user}/repos")
    fun listUserProjects(@Path("user") user: String?): Single<List<GitProjectDto>>
}