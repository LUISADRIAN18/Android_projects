package com.lagn.examplemvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lagn.examplemvvm.data.model.QuoteModel
import com.lagn.examplemvvm.data.model.QuoteProvider
import com.lagn.examplemvvm.domain.GetQuotesUseCase
import com.lagn.examplemvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {
    // encapsular el modelo que queremos en un liveData pero lo tenemos que meter en un MutableLiveData porque el modelo va ir cambiando
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()
    val getQuoteUseCases = GetQuotesUseCase()
    val getRandUseCases = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuoteUseCases()
            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)

            }
        }

    }

    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandUseCases()
        if (quote!=null){
            quoteModel.postValue(quote)
        }

        isLoading.postValue(false)


    }



}