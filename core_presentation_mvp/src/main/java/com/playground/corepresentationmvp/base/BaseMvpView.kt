package com.playground.corepresentationmvp.base

import com.arellomobile.mvp.MvpView
import com.playground.corepresentation.error.PresentationError
import io.reactivex.disposables.Disposable

interface BaseMvpView : MvpView {

    fun showLoading(disposable: Disposable? = null)

    fun showLoading() {
        showLoading(null)
    }

    fun hideLoading()

    fun showError(error: PresentationError.Visual)

    fun showMessage(message: String)
}