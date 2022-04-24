package com.example.gbgithub.domain.entitys

import com.google.gson.annotations.SerializedName

data class GitProjectEntity(
    val id: Int,
    @SerializedName("name")
    val nameProject: String,
)