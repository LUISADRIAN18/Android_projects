package com.lagn.examplemvvm.data.network

import com.lagn.examplemvvm.core.RetrofitHelper
import com.lagn.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuote(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuote()
            response.body() ?: emptyList()


        }

    }


}