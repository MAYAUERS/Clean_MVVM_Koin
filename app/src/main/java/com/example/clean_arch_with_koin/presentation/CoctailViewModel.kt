package com.example.clean_arch_with_koin.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_arch_with_koin.domain.model.Coctails
import com.example.clean_arch_with_koin.domain.useCase.CoctailsUseCase
import kotlinx.coroutines.launch

class CoctailViewModel(private val getCoctailsUseCase: CoctailsUseCase):ViewModel() {

    open val coctails:LiveData<Coctails> get() = _coctails
    private val _coctails= MutableLiveData<Coctails>()

    open val error:LiveData<String> get() = _error
    private val _error= MutableLiveData<String>()

    fun getCoctails(s:String){

        viewModelScope.launch {

        var response= getCoctailsUseCase.invoke(s)

            if (response.isSuccessful){
                _coctails.value=response.body()
            }else{
                _error.value= response.errorBody().toString()
            }

        }
    }
}