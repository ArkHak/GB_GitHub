package com.example.gbgithub.domain

import com.example.gbgithub.domain.entitys.GitUserEntity
import io.reactivex.rxjava3.core.Single

interface GitUsersRepo {

    val observeGitUserRepo: Single<List<GitUserEntity>>
}