package com.example.gbgithub.domain.entitys

import com.google.gson.annotations.SerializedName

data class GitUserEntity(
    val id: Int,
    val login: String,
    val name: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("public_repos")
    val publicRepos: Int,
    val followers: Int,
    val following: Int
)
