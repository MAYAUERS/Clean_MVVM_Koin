package com.example.clean_arch_with_koin.domain.useCase

import com.example.clean_arch_with_koin.domain.model.Coctails
import com.example.clean_arch_with_koin.domain.repository.CoctailRepository
import retrofit2.Response

class CoctailsUseCase (private val coctailRepository: CoctailRepository) {

    suspend operator fun invoke(s:String) :Response<Coctails>{

        return coctailRepository.getCoctails(s)
    }
}