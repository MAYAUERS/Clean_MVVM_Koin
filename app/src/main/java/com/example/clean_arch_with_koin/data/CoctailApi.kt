package com.example.clean_arch_with_koin.data

import com.example.clean_arch_with_koin.domain.model.Coctails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoctailApi {
//https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita
    @GET("api/json/v1/1/search.php?")
    suspend fun getCoctails(@Query("s") s:String?) : Response<Coctails>
}