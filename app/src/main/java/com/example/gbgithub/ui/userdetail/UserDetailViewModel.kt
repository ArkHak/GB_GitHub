package com.example.gbgithub.ui.userdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gbgithub.domain.GitUserProjectsList
import com.example.gbgithub.domain.entitys.GitProjectEntity
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class UserDetailViewModel(private val gitProjectsList: GitUserProjectsList) : ViewModel() {
    private val _userProjectsList = MutableLiveData<List<GitProjectEntity>>()
    val userProjectsList: LiveData<List<GitProjectEntity>> = _userProjectsList

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun updateUserProjectsListRepo(username: String) {
        compositeDisposable.add(
            gitProjectsList
                .observeGitUserProjectsList(username)
                .subscribeBy {
                    _userProjectsList.postValue(it)
                }
        )
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
