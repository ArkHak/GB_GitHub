package com.example.gbgithub.ui.userdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gbgithub.domain.RepositoryUsecase
import com.example.gbgithub.domain.entitys.GitProjectsEntity
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class UserDetailViewModel(
    private val repositoryUsecase: RepositoryUsecase
) : ViewModel() {

    private val _userProjectsList = MutableLiveData<List<GitProjectsEntity>>()
    val userProjectsList: LiveData<List<GitProjectsEntity>> = _userProjectsList

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun updateUserProjectsListRepo(username: String) {
        compositeDisposable.add(
            repositoryUsecase
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
