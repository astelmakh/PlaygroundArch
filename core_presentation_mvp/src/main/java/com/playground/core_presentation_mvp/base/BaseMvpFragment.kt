package com.playground.core_presentation_mvp.base

import com.arellomobile.mvp.MvpAppCompatFragment
import com.playground.core_presentation.error.PresentationError
import io.reactivex.disposables.Disposable

abstract class BaseMvpFragment : MvpAppCompatFragment(), BaseMvpView {

    override fun showLoading(disposable: Disposable?) {
        (activity as? BaseMvpActivity)?.showLoading(disposable)
    }

    override fun hideLoading() {
        (activity as? BaseMvpActivity)?.hideLoading()
    }

    override fun showError(error: PresentationError.Visual) {
        (activity as? BaseMvpActivity)?.showError(error)
    }

    override fun showMessage(message: String) {
        (activity as? BaseMvpActivity)?.showMessage(message)
    }
}