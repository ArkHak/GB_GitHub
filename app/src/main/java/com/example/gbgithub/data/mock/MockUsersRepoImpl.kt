package com.example.gbgithub.data.mock

import com.example.gbgithub.domain.UserRepo
import com.example.gbgithub.domain.entitys.GitProjectsEntity
import com.example.gbgithub.domain.entitys.GitUserEntity
import io.reactivex.rxjava3.core.Single

class MockUsersRepoImpl : UserRepo {

    private val mockListUsers = listOf(
        GitUserEntity(
            id = 0,
            login = "ArkHak",
            name = "Мысин Олег",
            avatarUrl = "https://avatars.githubusercontent.com/u/81629278?s=96&v=4",
            publicRepos = 7,
            followers = 5,
            following = 10,
            projectsList = listOf(
                GitProjectsEntity(
                    id = 0,
                    nameProject = "LOLOLO"
                ),
                GitProjectsEntity(
                    id = 1,
                    nameProject = "LOLOLO"
                ),
                GitProjectsEntity(
                    id = 2,
                    nameProject = "LOLOLO"
                ),
            )
        ),
        GitUserEntity(
            id = 1,
            login = "defunkt",
            name = "Chris Wanstrath",
            avatarUrl = "https://avatars.githubusercontent.com/u/2?v=4",
            publicRepos = 107,
            followers = 21404,
            following = 210,
            projectsList = listOf(
                GitProjectsEntity(
                    id = 0,
                    nameProject = "Trollololo"
                ),
                GitProjectsEntity(
                    id = 1,
                    nameProject = "Trollololo"
                ),
                GitProjectsEntity(
                    id = 2,
                    nameProject = "Trollololo"
                ),
            )

        ),
        GitUserEntity(
            id = 2,
            login = "octocat",
            name = "monalisa octocat",
            avatarUrl = "https://github.com/images/error/octocat_happy.gif",
            publicRepos = 2,
            followers = 20,
            following = 0,
            projectsList = listOf(
                GitProjectsEntity(
                    id = 0,
                    nameProject = "POlollolo"
                ),
                GitProjectsEntity(
                    id = 1,
                    nameProject = "POlollolo"
                ),
                GitProjectsEntity(
                    id = 2,
                    nameProject = "POlollolo"
                ),
            )
        ),
    )

    override fun getUsersList(): Single<List<GitUserEntity>> {
        return Single.just(mockListUsers)
    }

    override fun getProjectsUser(login: String): Single<List<GitProjectsEntity>> {
        var userProjects: List<GitProjectsEntity> = emptyList()
        mockListUsers.forEach { user ->
            if (user.login == login) {
                userProjects = user.projectsList
            }
        }
        return Single.just(userProjects)
    }

}