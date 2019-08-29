package com.playground.corepresentationmvp.base

import com.arellomobile.mvp.MvpAppCompatActivity
import com.playground.corepresentation.error.PresentationError
import io.reactivex.disposables.Disposable

abstract class BaseMvpActivity : MvpAppCompatActivity(), BaseMvpView {

    override fun showLoading(disposable: Disposable?) {
    }

    override fun hideLoading() {
    }

    override fun showError(error: PresentationError.Visual) {
    }

    override fun showMessage(message: String) {
    }
}