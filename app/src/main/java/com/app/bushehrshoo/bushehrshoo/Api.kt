package com.app.bushehrshoo.bushehrshoo

import retrofit2.Call
import retrofit2.http.GET

public interface Api {
    public val BASE_URL: String
        get() = "https://simplifiedcoding.net/demos/"

    @GET("marvel")
    public fun getHeroes(): Call<List<Hero>>
}