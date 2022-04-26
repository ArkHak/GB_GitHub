package com.example.gbgithub.domain.entitys

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitProjectsEntity(
    val id: Int,
    @SerializedName("name")
    val nameProject: String,
) : Parcelable