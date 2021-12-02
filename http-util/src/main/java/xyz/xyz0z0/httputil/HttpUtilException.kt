package xyz.xyz0z0.httputil


/**
 * http 请求异常，比如服务器 500 问题等
 */
class HttpUtilException : Exception {

    private var mCode: Int = -1

    constructor(code: Int, msg: String) : super(msg) {
        this.mCode = code
    }

    constructor(msg: String) : super(msg)

    constructor() : super()

    fun getMsg(): String {
        return "$mCode $message"
    }
}