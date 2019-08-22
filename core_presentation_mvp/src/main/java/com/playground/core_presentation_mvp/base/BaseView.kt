package com.playground.core_presentation_mvp.base

import com.arellomobile.mvp.MvpView
import com.playground.core_presentation_mvp.common.error.PresentationError
import io.reactivex.disposables.Disposable

interface BaseView : MvpView {

    fun showLoading(disposable: Disposable? = null)

    fun showLoading() {
        showLoading(null)
    }

    fun hideLoading()

    fun showError(error: PresentationError.Visual)

    fun showMessage(message: String)
}