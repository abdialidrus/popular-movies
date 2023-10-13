package com.abdialidrus.popularmovies.data.source.remote

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class RequestInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = initRequestBuilder(chain)
        val request = builder.build()
        return chain.proceed(request)
    }

    private fun initRequestBuilder(chain: Interceptor.Chain): Request.Builder {
        val request = chain.request()
        return request.newBuilder()
            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2MTJmODkyZTBjYWQ3N2E1ZTE2MjFmYmZiZmVkODdjNCIsInN1YiI6IjVjZWUzMjhkMGUwYTI2MzZhNWNhMTU5YSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.DL2NzYp1378v69PmpS1_HylTfyZgC78BQTuRxwEerjg")
            .method(request.method, request.body)
    }
}