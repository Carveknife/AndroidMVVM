package cn.cuibg.mvvm.http.respository

import android.text.TextUtils
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.lang.RuntimeException
import java.util.*

/**
 * description :
 * created time: 2020/11/13 16:34
 * created by: cuibenguang
 */
class RxHttpObserver<T> : Observer<T> {
    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
        val dataResponse = t as? DataResponse<*>
        if (!TextUtils.equals(dataResponse?.errorCode, "0")) {
            //onError()
        }
    }

    override fun onError(e: Throwable) {
    }
}