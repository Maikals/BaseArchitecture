package com.maikals.basearchitecture.exceptions

import android.util.Log
import com.maikals.domain.exceptions.BaseException

object ExceptionManager {

    private const val TAG = "ExceptionManager"

    fun manageError(exception: BaseException): String {
        Log.d(TAG, exception.message, exception)

        //this has to retrieve the message from database
        return exception.customMessage
    }
}
