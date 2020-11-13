package cn.cuibg.mvvm.http

import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * description :
 * created time: 2020/11/13 16:13
 * created by: cuibenguang
 */
class HttpManager private constructor() {
    companion object {
        @Volatile
        private var instance: HttpManager? = null;
        fun getInstance(): HttpManager {
            return instance ?: synchronized(this) {
                instance ?: HttpManager()
            }
        }
    }

    private fun <T> create(baseUrl: String, c: Class<T>): T {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(provideOKHttpClient())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(c)
    }

    private fun provideOKHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(HttpConstants.NETWORK_TIME.toLong(), TimeUnit.SECONDS)
            .readTimeout(HttpConstants.NETWORK_TIME.toLong(), TimeUnit.SECONDS)
            .writeTimeout(HttpConstants.NETWORK_TIME.toLong(), TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
        return builder.build()
    }
}