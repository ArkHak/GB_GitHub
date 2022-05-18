package com.example.gbgithub.di

import com.example.gbgithub.ui.userdetail.UserDetailFragment
import com.example.gbgithub.ui.userslist.UsersListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppDependenciesModuleDagger::class]
)
interface AppDependenciesComponent {
    fun inject(usersListFragment: UsersListFragment)
    fun inject(userDetailFragment: UserDetailFragment)
}