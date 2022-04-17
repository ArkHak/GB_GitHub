package com.example.gbgithub.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gbgithub.domain.GitUsersRepo
import com.example.gbgithub.domain.entitys.GitUserEntity
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class UsersListViewModel(private val gitUsersRepo: GitUsersRepo) : ViewModel() {

    private val _usersList = MutableLiveData<List<GitUserEntity>>()
    val usersList: LiveData<List<GitUserEntity>> = _usersList
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun updateUsersListRepo() {
        compositeDisposable.add(
            gitUsersRepo
                .observeGitUserRepo
                .subscribeBy {
                    _usersList.postValue(it)
                }
        )
    }


}