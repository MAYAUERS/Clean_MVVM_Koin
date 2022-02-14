package com.example.clean_arch_with_koin.domain.repository

import com.example.clean_arch_with_koin.domain.model.Coctails
import retrofit2.Response

interface CoctailRepository {


    suspend fun getCoctails(s:String) :Response<Coctails>

}