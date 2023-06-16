package com.lagn.examplemvvm.data

import com.lagn.examplemvvm.data.model.QuoteModel
import com.lagn.examplemvvm.data.model.QuoteProvider
import com.lagn.examplemvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()
    suspend fun getAllQuotes(): List<QuoteModel>{
        val response = api.getQuote()
        QuoteProvider.quotes = response
        return response
    }
}