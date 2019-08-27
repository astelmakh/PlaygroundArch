package com.playground.featureshowcase.presentation.list

import com.arellomobile.mvp.InjectViewState
import com.playground.core_presentation.error.PresentationError
import com.playground.core_presentation.error.PresentationErrorFactory
import com.playground.core_presentation_mvp.base.BaseMvpPresenter
import com.playground.featureshowcase.di.ShowCaseNavigation
import com.playground.featureshowcase.domain.ShowCaseInteractor
import com.playground.featureshowcase.presentation.model.ShowCaseItemModel
import com.playground.featureshowcase.presentation.navigation.ShowCaseNavigationScreens
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ShowCaseListPresenter
@Inject constructor(
    private val showCaseInteractor: ShowCaseInteractor,
    private val mapper: ShowCaseItemModel.Mapper,
    @ShowCaseNavigation private val router: Router
) :
    BaseMvpPresenter<ShowCaseListView>(CompositeDisposable()) {

    fun init() {
        compositeDisposable.add(
            showCaseInteractor.getInfo()
                .subscribeOn(Schedulers.io())
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
        router.navigateTo(ShowCaseNavigationScreens.Details(item))
    }

    fun refreshRequest() {
        compositeDisposable.add(
            showCaseInteractor.refreshInfo()
                .subscribeOn(Schedulers.io())
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
}