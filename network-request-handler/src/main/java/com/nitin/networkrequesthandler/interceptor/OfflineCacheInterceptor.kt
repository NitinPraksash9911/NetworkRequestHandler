package com.nitin.networkrequesthandler.interceptor

import com.nitin.networkrequesthandler.utils.Cacheable
import com.nitin.networkrequesthandler.utils.ConnectionManager
import com.nitin.networkrequesthandler.utils.NetworkConstant.HEADER_CACHE_CONTROL
import com.nitin.networkrequesthandler.utils.NetworkConstant.HEADER_PRAGMA
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class OfflineCacheInterceptor  @Inject constructor(private val connectionManager: ConnectionManager) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val invocation: Invocation? = request.tag(Invocation::class.java)

        if (invocation != null) {
            val annotation: Cacheable? =
                invocation.method().getAnnotation(Cacheable::class.java)

            /* check if this request has the [Cacheable] annotation */
            if (annotation != null &&
                annotation.annotationClass.simpleName.equals("Cacheable") &&
                connectionManager.isConnected().not()
            ) {
                Timber.d("CACHE ANNOTATION: called.::%s", annotation.annotationClass.simpleName)

                // prevent caching when network is on. For that we use the "networkInterceptor"
                Timber.d("cache interceptor: called.")
                val cacheControl = CacheControl.Builder()
                    .maxStale(7, TimeUnit.DAYS)
                    .build()

                request = request.newBuilder()
                    .removeHeader(HEADER_PRAGMA)
                    .removeHeader(HEADER_CACHE_CONTROL)
                    .cacheControl(cacheControl)
                    .build()
            } else {
                Timber.d("cache interceptor: not called.")
            }
        }
        return chain.proceed(request)
    }
}