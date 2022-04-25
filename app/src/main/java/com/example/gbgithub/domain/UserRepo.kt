package com.example.gbgithub.domain

import com.example.gbgithub.domain.entitys.GitProjectsEntity
import com.example.gbgithub.domain.entitys.GitUserEntity
import io.reactivex.rxjava3.core.Single

interface UserRepo {
    // C(R)UD
    fun getUsersList(): Single<List<GitUserEntity>>
    fun getProjectsUser(login: String): Single<List<GitProjectsEntity>>
}