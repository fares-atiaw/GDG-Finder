package com.example.android.gdgfinder.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"
interface GdgApiService {
    @GET("gdg-directory.json")   // The Coroutine Call Adapter allows us to return a Deferred, a Job with a result
//    fun getChapters():
//            Deferred<GdgResponse>
    suspend fun getChapters():
        GdgResponse
}
//private val moshi = Moshi.Builder()
//        .add(KotlinJsonAdapterFactory())
//        .build()
//.addConverterFactory(MoshiConverterFactory.create(moshi))
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

object GdgApi {
    val retrofitService : GdgApiService by lazy { retrofit.create(GdgApiService::class.java) }
}
