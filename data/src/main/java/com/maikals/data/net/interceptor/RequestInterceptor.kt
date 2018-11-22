package com.maikals.data.net.interceptor

import android.util.Log
import com.maikals.data.BuildConfig
import com.maikals.data.entity.ApiKeyContainer
import com.maikals.data.net.ApiConstants
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        var request = chain?.request()
        var url = request?.url()

        val urlBuilder = url?.newBuilder()
        //put common queries
        urlBuilder?.addEncodedQueryParameter(
            ApiConstants.QUERY_PARAM_API_KEY,
            ApiKeyContainer.apiKey
        ) //put your own api_key

        url = urlBuilder?.build()
        request = request?.newBuilder()?.url(url!!)?.build()
        if (BuildConfig.DEBUG) Log.d("RequestInterceptor", "URl -> " + request?.url())
        return chain?.proceed(request!!)!!
    }
}
