package com.playground.featureshowcase.presentation.list

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.playground.core_presentation_mvp.base.BasePresenter
import com.playground.core_presentation_mvp.common.error.PresentationError
import com.playground.core_presentation_mvp.common.error.PresentationErrorFactory
import com.playground.corenavigation.IntentKey
import com.playground.corenavigation.Navigator
import com.playground.featureshowcase.domain.ShowCaseInteractor
import com.playground.featureshowcase.presentation.list.model.ShowCaseItemModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@InjectViewState
class ShowCasePresenter
@Inject constructor(
    private val showCaseInteractor: ShowCaseInteractor,
    private val mapper: ShowCaseItemModel.Mapper,
    private val navigator: Navigator,
    private val context: Context
) :
    BasePresenter<ShowCaseView>(CompositeDisposable()) {

    fun init() {
        compositeDisposable.add(
            showCaseInteractor.getInfo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ it ->
                    viewState.hideLoading()
                    viewState.renderShowCases(it.map { mapper.map(it) })
                }, {
                    viewState.hideLoading()
                    PresentationErrorFactory.create(it).apply {
                        if (it is PresentationError.Visual) {
                            viewState.showError(it)
                        }
                    }
                })
        )
        viewState.showLoading()
    }

    fun showCaseChosen(item: ShowCaseItemModel) {
        navigator.createIntent(context, IntentKey.Purchase("", "", ""))
    }
}