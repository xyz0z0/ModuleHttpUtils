package xyz.xyz0z0.httputil

import okhttp3.RequestBody
import okhttp3.ResponseBody

/**
 * Author: Cheng
 * Date: 2021/8/17 17:42
 * Description: xyz.xyz0z0.httputil
 */
interface IHttpEngine {

    fun get(pathUrl: String, headerMap: MutableMap<String, String>): ResponseBody

    fun post(url: String, headerMap: MutableMap<String, String>, requestBody: RequestBody): ResponseBody

}