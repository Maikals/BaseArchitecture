package com.maikals.domain.useCase

import com.maikals.domain.entities.BaseEntity
import com.maikals.domain.entities.BaseParams
import com.maikals.domain.exceptions.BaseException
import kotlinx.coroutines.*

abstract class BaseUseCase<T : BaseEntity, Params : BaseParams> {

    private var job: Job? = null

    companion object {
        private const val TAG: String = "BaseUseCase"
    }

    fun executeAsync(
        params: Params, block: (T) -> Unit,
        blockError: (BaseException?) -> Unit
    ) {
        job = launchUI({
            launchRepoCallAsync(params, block)
        }, blockError)

    }

    private suspend fun launchRepoCallAsync(params: Params, block: (T) -> Unit) {
        launchAsync {
            val result = buildRepoCall(params)
            withMainContext { block(result) }
        }
    }

    abstract fun getTag(): String

    protected abstract suspend fun buildRepoCall(params: Params): T

    private fun createExceptionHandler(blockError: (BaseException?) -> Unit) =
        CoroutineExceptionHandler { _, e ->
            blockError(e as BaseException)
        }

    /**
     * Launch a coroutine in a new Thread.
     * @param block The block that will be executed inside coroutine
     */
    private suspend fun launchAsync(block: suspend CoroutineScope.() -> Unit) =
        withContext(Dispatchers.IO) {
            block()
        }

    private suspend fun withMainContext(block: () -> Unit) {
        withContext(Dispatchers.Main) {
            block()
        }
    }

    /**
     * Launch a coroutine in the main thread.
     * @param block The block that will be executed inside coroutine
     */
    private fun launchUI(block: suspend CoroutineScope.() -> Unit, blockError: (BaseException?) -> Unit = {}): Job =
        GlobalScope.launch(Dispatchers.Main + createExceptionHandler(blockError)) {
            block()
        }

    /**
     * Cancels the current job execution.
     */
    fun cancel() = job?.cancel()
}
