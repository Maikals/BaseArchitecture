package com.maikals.basearchitecture.view.base

import android.util.Log
import androidx.lifecycle.ViewModel
import com.maikals.basearchitecture.exceptions.ExceptionManager
import com.maikals.domain.entities.BackendException
import com.maikals.domain.entities.BaseEntity
import com.maikals.domain.entities.BaseParams
import com.maikals.domain.useCase.BaseUseCase
import com.maikals.domain.useCase.wrappers.BaseUseCaseWrapper
import kotlin.reflect.KClass

abstract class BaseViewModel(private val useCaseWrapper: BaseUseCaseWrapper) : ViewModel() {

    companion object {
        const val TAG = "BaseViewModel"
    }

    override fun onCleared() {
        super.onCleared()
        useCaseWrapper.cancelUseCases()
    }

    fun <T : BaseUseCase<*, *>> execute(
        classType: KClass<T>,
        params: BaseParams,
        onResultOk: (BaseEntity) -> Unit,
        onResultError: (String) -> Unit
    ) {
        try {
            useCaseWrapper.getUseCase(classType)!!.executeAsync(params, {
                onResultOk(it)
            }, {
                Log.e("BaseViewModel", "Error", it)
                onResultError(ExceptionManager.manageError(it ?: BackendException()))
            })

        } catch (exception: KotlinNullPointerException) {
            Log.e(TAG, "The UseCase that you are trying to use is not in the UseCaseWrapper", exception)
        }
    }

}
