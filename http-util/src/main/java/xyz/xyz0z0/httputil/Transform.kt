package xyz.xyz0z0.httputil

import okhttp3.RequestBody
import okhttp3.ResponseBody

/**
 * Author: Cheng
 * Date: 2021/10/20 9:03
 * Description: xyz.xyz0z0.httputil
 */
interface Transform {

    fun transformResponse(responseBody: ResponseBody): String


}