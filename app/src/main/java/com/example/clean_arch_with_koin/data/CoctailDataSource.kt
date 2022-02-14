package com.example.clean_arch_with_koin.data

import com.example.clean_arch_with_koin.domain.model.Coctails
import com.example.clean_arch_with_koin.domain.repository.CoctailRepository
import retrofit2.Response

class CoctailDataSource(private val coctailApi: CoctailApi) : CoctailRepository {

    override suspend fun getCoctails(s: String): Response<Coctails> {
      return  coctailApi.getCoctails(s)
    }
}