package com.example.gbgithub

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.gbgithub.di.AppDependenciesComponent
import com.example.gbgithub.di.DaggerAppDependenciesComponent

class App : Application() {
    lateinit var appDependenciesComponent: AppDependenciesComponent

    override fun onCreate() {
        super.onCreate()
        appDependenciesComponent = DaggerAppDependenciesComponent
            .builder()
            .build()
    }
}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app