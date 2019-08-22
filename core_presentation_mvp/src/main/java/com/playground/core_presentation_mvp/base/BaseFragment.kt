package com.playground.core_presentation_mvp.base

import com.arellomobile.mvp.MvpAppCompatFragment
import com.playground.core_presentation_mvp.common.error.PresentationError
import io.reactivex.disposables.Disposable

abstract class BaseFragment : MvpAppCompatFragment(), BaseView {

    override fun showLoading(disposable: Disposable?) {
        (activity as? BaseActivity)?.showLoading(disposable)
    }

    override fun hideLoading() {
        (activity as? BaseActivity)?.hideLoading()
    }

    override fun showError(error: PresentationError.Visual) {
        (activity as? BaseActivity)?.showError(error)
    }

    override fun showMessage(message: String) {
        (activity as? BaseActivity)?.showMessage(message)
    }
}