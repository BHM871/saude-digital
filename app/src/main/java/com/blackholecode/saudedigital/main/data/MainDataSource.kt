package com.blackholecode.saudedigital.main.data

import com.blackholecode.saudedigital.common.base.Cache
import com.blackholecode.saudedigital.common.base.RequestCallback

interface MainDataSource {

    fun logout(callback: RequestCallback<Boolean>) {throw UnsupportedOperationException()}

    fun <T> removeCache(cache: Cache<T>) {throw UnsupportedOperationException()}

}