package xyz.xyz0z0.httputil

import okhttp3.FormBody

/**
 * Author: Cheng
 * Date: 2021/10/29 14:36
 * Description: xyz.xyz0z0.httputil
 */

/**
 * 用于封装 FormBody
 */
fun Map<String, Any>.toFormBody(): FormBody {
    val fromBodyBuilder = FormBody.Builder()
    for ((key, value) in this) {
        fromBodyBuilder.add(key, value.toString())
    }
    return fromBodyBuilder.build()
}

/**
 * 用于 get 请求拼接参数
 */
fun Map<String,Any>.toParamUrl(url:String):String{
    if (this.isEmpty()) {
        return url
    }
    val sb = StringBuilder(url)
    if (!url.contains("?")) {
        sb.append("?")
    } else {
        if (!url.endsWith("?")) {
            sb.append("&")
        }
    }
    for ((key, value) in this) {
        sb.append("$key=$value&")
    }
    sb.deleteCharAt(sb.length - 1)
    return sb.toString()
}