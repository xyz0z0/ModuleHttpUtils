package xyz.xyz0z0.modulehttputil

import android.content.Context
import okhttp3.OkHttpClient
import xyz.xyz0z0.httputil.HttpUtils
import xyz.xyz0z0.persistentcookiejar.ClearableCookieJar
import xyz.xyz0z0.persistentcookiejar.PersistentCookieJar
import xyz.xyz0z0.persistentcookiejar.cache.SetCookieCache
import xyz.xyz0z0.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import java.util.concurrent.TimeUnit


/**
 * Author: Cheng
 * Date: 2021/10/25 9:10
 * Description: cn.com.gynybx.common_library.network.customer
 */

object HttpInitUtils {

    fun init(context: Context) {
        val cookieJar: ClearableCookieJar = PersistentCookieJar(SetCookieCache(), SharedPrefsCookiePersistor(context.applicationContext))

        val defaultHttpClient = OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .cookieJar(cookieJar)
            .build()
        HttpUtils.initHttpClient(defaultHttpClient)
    }

}