package com.playground.core_presentation_mvp.base

import com.arellomobile.mvp.MvpAppCompatActivity
import com.playground.core_presentation_mvp.common.error.PresentationError
import io.reactivex.disposables.Disposable

abstract class BaseActivity : MvpAppCompatActivity(), BaseView {

    override fun showLoading(disposable: Disposable?) {

    }

    override fun hideLoading() {

    }

    override fun showError(error: PresentationError.Visual) {

    }

    override fun showMessage(message: String) {

    }
}