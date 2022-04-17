package com.example.gbgithub

import android.app.Application
import android.content.Context
import com.example.gbgithub.data.MockGitUsersRepoImpl
import com.example.gbgithub.domain.GitUsersRepo

class App : Application() {
    val gitUsersRepo: GitUsersRepo by lazy { MockGitUsersRepoImpl() }
}

val Context.app: App
    get() = applicationContext as App
