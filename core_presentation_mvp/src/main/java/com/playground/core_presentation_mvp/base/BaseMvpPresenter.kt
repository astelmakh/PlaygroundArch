package com.playground.core_presentation_mvp.base

import com.arellomobile.mvp.MvpPresenter
import com.playground.core_presentation.error.PresentationError
import com.playground.core_presentation.error.PresentationErrorFactory
import io.reactivex.disposables.CompositeDisposable

abstract class BaseMvpPresenter<View : BaseMvpView>(protected val compositeDisposable: CompositeDisposable) :
    MvpPresenter<View>() {

    internal fun processError(e: Throwable, content: PresentationErrorFactory.Content? = null) {
        val error = PresentationErrorFactory.create(e)
        processPresentationError(error)
    }

    protected fun processPresentationError(error: PresentationError) {
        if (error is PresentationError.Visual) {
            viewState.showError(error)
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}