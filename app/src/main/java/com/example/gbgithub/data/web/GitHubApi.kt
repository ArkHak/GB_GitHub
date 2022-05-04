package com.example.gbgithub.data.web

import com.example.gbgithub.domain.dto.GitProjectDto
import com.example.gbgithub.domain.dto.GitUserDto
import io.reactivex.rxjava3.core.Single
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {

    @GET("users")
    fun getListUsers(): Single<List<GitUserDto>>

    @GET("users/{user}")
    fun getUserDetail(@Path("user") user: String): Single<GitUserDto>

    @GET("users/{user}/repos")
    fun getListUserProjects(@Path("user") user: String): Single<List<GitProjectDto>>
}