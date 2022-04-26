package com.example.gbgithub.domain.dto

import com.google.gson.annotations.SerializedName

data class GitProjectDto(
    val id: Int,
    @SerializedName("name")
    val nameProject: String,
)