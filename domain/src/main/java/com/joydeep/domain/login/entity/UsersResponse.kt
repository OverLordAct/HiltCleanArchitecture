package com.joydeep.domain.login.entity

import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val per_page: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("total_pages") val total_pages: Int,
    @SerializedName("data") val data: List<User>,
    @SerializedName("support") val support: Support
) {
    data class User(
        @SerializedName("id") val id: Int,
        @SerializedName("email") val email: String,
        @SerializedName("first_name") val first_name: String,
        @SerializedName("last_name") val last_name: String,
        @SerializedName("avatar") val avatar: String
    )

    data class Support(
        @SerializedName("url") val url: String,
        @SerializedName("text") val text: String
    )
}

