package com.lagn.examplemvvm.domain

import com.lagn.examplemvvm.data.QuoteRepository
import com.lagn.examplemvvm.data.model.QuoteModel
import com.lagn.examplemvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    //private  val repository = QuoteRepository()

    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomnu = (quotes.indices).random()
            return quotes[randomnu]
        }
        return null
    }
}