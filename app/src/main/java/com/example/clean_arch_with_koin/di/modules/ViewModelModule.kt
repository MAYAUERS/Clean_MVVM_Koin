package com.example.clean_arch_with_koin.di.modules

import com.example.clean_arch_with_koin.data.CoctailDataSource
import com.example.clean_arch_with_koin.domain.repository.CoctailRepository
import com.example.clean_arch_with_koin.domain.useCase.CoctailsUseCase
import com.example.clean_arch_with_koin.presentation.CoctailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule= module {

    viewModel {
        CoctailViewModel(getCoctailsUseCase=get())
    }
}
val dataModule= module {
    single<CoctailRepository> { CoctailDataSource(coctailApi=get()) }

}
val domainModule= module {
    factory { CoctailsUseCase(coctailRepository=get()) }
}