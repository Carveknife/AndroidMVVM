package cn.carveknife.mvvm.http.exception

import java.lang.RuntimeException

/**
 * description :
 * created time: 2020/11/13 17:15
 * created by: cuibenguang
 */
class NetworkErrorException(message: String?) : RuntimeException(message) {
}