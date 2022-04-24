package com.example.gbgithub.data

import com.example.gbgithub.domain.GitUsersList
import com.example.gbgithub.domain.entitys.GitUserEntity
import io.reactivex.rxjava3.core.Single

class MockGitUsersListImpl : GitUsersList {

    private val dummyListUsers = listOf(
        GitUserEntity(
            id = 0,
            login = "ArkHak",
            name = "Мысин Олег",
            avatarUrl = "https://avatars.githubusercontent.com/u/81629278?s=96&v=4",
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
            login = "octocat",
            name = "monalisa octocat",
            avatarUrl = "https://github.com/images/error/octocat_happy.gif",
            publicRepos = 2,
            followers = 20,
            following = 0
        ),
    )

    override val observeGitUsersList: Single<List<GitUserEntity>>
        get() = Single.just(dummyListUsers)
}