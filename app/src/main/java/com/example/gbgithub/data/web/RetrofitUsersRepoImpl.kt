package com.example.gbgithub.data.web

import com.example.gbgithub.domain.UserRepo
import com.example.gbgithub.domain.dto.GitProjectDto
import com.example.gbgithub.domain.dto.GitUserDto
import com.example.gbgithub.domain.entitys.GitProjectsEntity
import com.example.gbgithub.domain.entitys.GitUserEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL_API_GITHUB = "https://api.github.com/"

class RetrofitUsersRepoImpl : UserRepo {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_API_GITHUB)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    private val api: GitHubApi = retrofit.create(GitHubApi::class.java)

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