package com.example.android.gdgfinder.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class GdgChapter(
    @SerializedName("chapter_name") val name: String,
    @SerializedName("cityarea") val city: String,
    val country: String,
    val region: String,
    val website: String,
    val geo: LatLong
 ): Parcelable

@Parcelize
data class LatLong(
    val lat: Double,
    @SerializedName("lng")
    val long: Double
) : Parcelable

@Parcelize
data class GdgResponse(
        @SerializedName("filters_") val filters: Filter,
        @SerializedName("data") val chapters: List<GdgChapter>
): Parcelable

@Parcelize
data class Filter(
        @SerializedName("region") val regions: List<String>
): Parcelable
