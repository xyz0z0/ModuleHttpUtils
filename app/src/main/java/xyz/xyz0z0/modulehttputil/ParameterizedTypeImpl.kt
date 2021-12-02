package xyz.xyz0z0.modulehttputil

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * created by chengxugang on 2019/11/12
 */
class ParameterizedTypeImpl(private val raw: Class<*>, args: Array<Type>?) : ParameterizedType {
    private val args: Array<Type> = args ?: arrayOf()

    override fun getActualTypeArguments(): Array<Type> {
        return args
    }

    override fun getRawType(): Type {
        return raw
    }

    override fun getOwnerType(): Type? {
        return null
    }

}