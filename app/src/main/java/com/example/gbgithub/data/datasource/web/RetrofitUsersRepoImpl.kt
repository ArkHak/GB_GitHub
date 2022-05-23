package com.example.gbgithub.data.datasource.web

import com.example.gbgithub.domain.UserRepo
import com.example.gbgithub.data.datasource.web.dto.GitProjectDto
import com.example.gbgithub.data.datasource.web.dto.GitUserDto
import com.example.gbgithub.domain.entitys.GitProjectsEntity
import com.example.gbgithub.domain.entitys.GitUserEntity
import io.reactivex.rxjava3.core.Single
import org.koin.java.KoinJavaComponent.get
import org.koin.java.KoinJavaComponent.inject

class RetrofitUsersRepoImpl(
    private val api: GitHubApi
) : UserRepo {

    override fun getUsersList(): Single<List<GitUserEntity>> {
        return api.getListUsers().map { users ->
            convertUserDtoToEntity(users)
        }
    }

    override fun getProjectsUser(login: String): Single<List<GitProjectsEntity>> {
        return api.getListUserProjects(login).map { projects ->
            convertProjectDtoToEntity(projects)
        }
    }

    private fun convertUserDtoToEntity(usersDto: List<GitUserDto>): List<GitUserEntity> {
        val listUsersEntity = mutableListOf<GitUserEntity>()
        usersDto.forEach { userDto ->
            listUsersEntity.add(
                GitUserEntity(
                    id = userDto.id,
                    login = userDto.login,
                    name = "userDto.name",
                    avatarUrl = userDto.avatarUrl,
                    publicRepos = 2,
                    followers = 2,
                    following = 2,
                )
            )
        }
        return listUsersEntity
    }

    private fun convertProjectDtoToEntity(projects: List<GitProjectDto>): List<GitProjectsEntity> {
        val listProjectsEntity = mutableListOf<GitProjectsEntity>()
        projects.forEach { projectDto ->
            listProjectsEntity.add(
                GitProjectsEntity(
                    id = projectDto.id,
                    nameProject = projectDto.nameProject
                )
            )
        }
        return listProjectsEntity
    }
}