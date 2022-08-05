package com.example.catcraft.ui.listframent.datasource.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatBreedData(
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: Image? = Image(System.currentTimeMillis().toString(), null),
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val desc: String,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("life_span")
    val lifeSpan: String? = "",
) : Parcelable {
    @Parcelize
    data class Image(
        @SerializedName("id")
        val id: String,
        @SerializedName("url")
        val url: String? = null,
    ) : Parcelable

}
