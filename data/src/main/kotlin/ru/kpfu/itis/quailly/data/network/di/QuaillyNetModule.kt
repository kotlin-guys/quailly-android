package ru.kpfu.itis.quailly.data.network.di

import com.example.template.data.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.kpfu.itis.quailly.core.di.PerApp
import ru.kpfu.itis.quailly.data.local.token_helper.TokenHelper
import ru.kpfu.itis.quailly.data.network.api.QuaillyNotAuthedApi
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier

@Module
class QuaillyNetModule {

    private companion object {
        const val TIMEOUT = 10L
        const val HEADER_AUTH = "Authorization:"
    }

    @Provides
    @PerApp
    fun notAuthedQuaillyApi(@NotAuthedQualifier retrofit: Retrofit) = retrofit.create(QuaillyNotAuthedApi::class.java)

    @Provides
    @PerApp
    @NotAuthedQualifier
    fun notAuthedRetrofit(
        @NotAuthedQualifier okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.QUAILLY_BACK_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()

    @Provides
    @PerApp
    @NotAuthedQualifier
    fun notAuthedOkHttp(@LoggingQualifier loggingInterceptor: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) builder.addInterceptor(loggingInterceptor)

        return builder.build()
    }

    @Provides
    @PerApp
    @AuthedQualifier
    fun authedRetrofit(
        @AuthedQualifier okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.QUAILLY_BACK_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()

    @Provides
    @PerApp
    @AuthedQualifier
    fun authedOkHttp(
        @LoggingQualifier loggingInterceptor: Interceptor,
        @AuthedQualifier interceptor: Interceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(interceptor)

        if (BuildConfig.DEBUG) builder.addInterceptor(loggingInterceptor)

        return builder.build()
    }

    @Provides
    @PerApp
    @AuthedQualifier
    fun authedInterceptor(tokenHelper: TokenHelper): Interceptor = Interceptor {
        var request = it.request()

        tokenHelper.getToken()?.let {token ->
            request = request.newBuilder()
                .addHeader(HEADER_AUTH, token)
                .build()
        }

        it.proceed(request)
    }
}

@Qualifier
annotation class AuthedQualifier

@Qualifier
annotation class NotAuthedQualifier