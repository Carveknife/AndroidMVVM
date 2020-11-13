package cn.cuibg.mvvm.http.respository

import com.google.gson.annotations.SerializedName

/**
 * description :
 * created time: 2020/11/13 16:25
 * created by: cuibenguang
 */
data class DataResponse<T>(
    @SerializedName("data")
    val data: T?,
    @SerializedName("status")
    val status: Int,
    @SerializedName("error_code")
    val errorCode: String,
    @SerializedName("error")
    val error: String,
    @SerializedName("code")
    val code: String
) {
}