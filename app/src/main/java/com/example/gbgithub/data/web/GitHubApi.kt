package com.example.gbgithub.data.web

import com.example.gbgithub.data.web.dto.GitProjectDto
import com.example.gbgithub.data.web.dto.GitUserDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("users")
    fun getListUsers(): Single<List<GitUserDto>>

    @GET("users/{user}")
    fun getUserDetail(@Path("user") user: String): Single<GitUserDto>

    @GET("users/{user}/repos")
    fun getListUserProjects(@Path("user") user: String): Single<List<GitProjectDto>>
}