package com.example.gbgithub.domain

import com.example.gbgithub.domain.entitys.GitProjectEntity
import io.reactivex.rxjava3.core.Single

interface GitUserProjectsList {
    fun observeGitUserProjectsList(username: String): Single<List<GitProjectEntity>>
}