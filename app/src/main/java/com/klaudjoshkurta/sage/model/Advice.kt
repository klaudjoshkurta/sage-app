package com.klaudjoshkurta.sage.model

import com.google.gson.annotations.SerializedName

data class Advice(
    val slip: Slip
)

data class Slip(
    @SerializedName("slip_id")
    val id: Int,
    val advice: String
)