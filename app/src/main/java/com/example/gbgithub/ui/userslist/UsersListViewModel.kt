package com.example.gbgithub.ui.userslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gbgithub.domain.GitUsersList
import com.example.gbgithub.domain.entitys.GitUserEntity
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class UsersListViewModel(private val gitUsersList: GitUsersList) : ViewModel() {

    private val _usersList = MutableLiveData<List<GitUserEntity>>()
    val usersList: LiveData<List<GitUserEntity>> = _usersList

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun updateUsersListRepo() {
        compositeDisposable.add(
            gitUsersList
                .observeGitUsersList
                .subscribeBy {
                    _usersList.postValue(it)
                }
        )
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}