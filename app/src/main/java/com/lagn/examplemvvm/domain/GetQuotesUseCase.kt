package com.lagn.examplemvvm.domain

import com.lagn.examplemvvm.data.QuoteRepository
import com.lagn.examplemvvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()
    suspend operator fun invoke(): List<QuoteModel>? {
        return repository.getAllQuotes()
    }

}