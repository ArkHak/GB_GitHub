package com.example.gbgithub.data.web.dto

import com.google.gson.annotations.SerializedName

data class GitProjectDto(
    val id: Int,
    @SerializedName("name")
    val nameProject: String,
)