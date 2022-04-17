package com.example.gbgithub.data

import com.example.gbgithub.domain.GitUsersRepo
import com.example.gbgithub.domain.entitys.GitUserEntity
import com.google.gson.annotations.SerializedName
import io.reactivex.rxjava3.core.Single

class MockGitUsersRepoImpl : GitUsersRepo {

    private val dummyList = listOf(
        GitUserEntity(
            id = 0,
            login = "Mys_ya",
            name = "Мысин Олег",
            avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4",
            publicRepos = 7,
            followers = 5,
            following = 10
        ),
        GitUserEntity(
            id = 1,
            login = "defunkt",
            name = "Chris Wanstrath",
            avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4",
            publicRepos = 107,
            followers = 21404,
            following = 210
        ),
        GitUserEntity(
            id = 2,
            login = "defunkt",
            name = "Chris Wanstrath",
            avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4",
            publicRepos = 107,
            followers = 21404,
            following = 210
        ),
        GitUserEntity(
            id = 3,
            login = "defunkt",
            name = "Chris Wanstrath",
            avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4",
            publicRepos = 107,
            followers = 21404,
            following = 210
        ),
        GitUserEntity(
            id = 4,
            login = "defunkt",
            name = "Chris Wanstrath",
            avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4",
            publicRepos = 107,
            followers = 21404,
            following = 210
        ),
    )

    override val observeGitUserRepo: Single<List<GitUserEntity>>
        get() = Single.just(dummyList)
}