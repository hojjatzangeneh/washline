package com.app.bushehrshoo.bushehrshoo

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiMovies{
    @GET("/file/versions/movies-api.json")
fun getMovies(): Observable<MovieResponse>
 }