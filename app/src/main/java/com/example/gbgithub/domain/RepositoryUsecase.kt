package com.example.gbgithub.domain

import com.example.gbgithub.domain.entitys.GitProjectsEntity
import com.example.gbgithub.domain.entitys.GitUserEntity
import io.reactivex.rxjava3.core.Single

interface RepositoryUsecase {
    fun observeUsersList(): Single<List<GitUserEntity>>
    fun observeGitUserProjectsList(login: String): Single<List<GitProjectsEntity>>
}