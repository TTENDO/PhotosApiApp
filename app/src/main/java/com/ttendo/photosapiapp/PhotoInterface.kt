package com.ttendo.photosapiapp

import retrofit2.http.GET

interface PhotoInterface {
    @GET("photos")
    suspend fun getPhotos():List<Photos>
}