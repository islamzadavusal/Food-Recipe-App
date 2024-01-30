package com.islamzada.network.injector

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenInjector @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val authRequest = originalRequest.newBuilder()
            .url(originalRequest.url.newBuilder().addQueryParameter("apiKey", "0d092f575dbf4ef29ce80db8b3ffb7ae").build())
            .method(originalRequest.method, originalRequest.body)

        return chain.proceed(authRequest.build())
    }
}