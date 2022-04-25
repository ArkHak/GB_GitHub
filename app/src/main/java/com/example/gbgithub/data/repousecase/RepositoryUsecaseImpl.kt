package com.example.gbgithub.data.repousecase

import com.example.gbgithub.domain.UserRepo
import com.example.gbgithub.domain.RepositoryUsecase
import com.example.gbgithub.domain.entitys.GitProjectsEntity
import com.example.gbgithub.domain.entitys.GitUserEntity
import io.reactivex.rxjava3.core.Single

class RepositoryUsecaseImpl(private val userRepo: UserRepo) : RepositoryUsecase {

    override fun observeUsersList(): Single<List<GitUserEntity>> {
        return userRepo.getUsersList()
    }

    override fun observeGitUserProjectsList(login: String): Single<List<GitProjectsEntity>> {
        return userRepo.getProjectsUser(login)
    }
}