package com.nurettinselim.developermulticampfinishproject.data

import com.nurettinselim.developermulticampfinishproject.data.model.Community
import retrofit2.http.GET

interface MyApi {
    @GET("/multicamp/communities")
    suspend fun getCommunities(): List<Community>?
}