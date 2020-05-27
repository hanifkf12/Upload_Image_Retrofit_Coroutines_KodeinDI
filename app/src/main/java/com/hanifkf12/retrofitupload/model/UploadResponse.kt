package com.hanifkf12.retrofitupload.model


import com.google.gson.annotations.SerializedName

data class UploadResponse(
    @SerializedName("file")
    var `file`: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("path")
    var path: String?
)