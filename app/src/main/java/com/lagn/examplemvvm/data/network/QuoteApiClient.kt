package com.lagn.examplemvvm.data.network

import com.lagn.examplemvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    @GET(".json")
    suspend fun getAllQuote(): Response<List<QuoteModel>>


}