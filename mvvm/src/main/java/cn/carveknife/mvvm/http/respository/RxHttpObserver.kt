package cn.carveknife.mvvm.http.respository

import android.content.Context
import android.text.TextUtils
import cn.carveknife.mvvm.http.exception.NetworkErrorException
import com.blankj.utilcode.util.NetworkUtils
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * description :
 * created time: 2020/11/13 16:34
 * created by: cuibenguang
 */
class RxHttpObserver<T>(context: Context) : Observer<T> {
    private val mContext: Context?;

    init {
        mContext = context;
    }

    override fun onSubscribe(d: Disposable) {
        if (NetworkUtils.isConnected()) {
            onError(NetworkErrorException("网络连接失败！请重试！"))
        }
    }

    override fun onNext(t: T) {
        val dataResponse = t as? DataResponse<*>
        if (!TextUtils.equals(dataResponse?.errorCode, "0")) {
            //onError()
        }
    }

    override fun onError(e: Throwable) {
    }

    override fun onComplete() {
    }
}