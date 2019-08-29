package com.playground.featureshowcase.presentation.details

import com.arellomobile.mvp.InjectViewState
import com.playground.corepresentationmvp.base.BaseMvpPresenter
import com.playground.corenavigation.GlobalFeature
import com.playground.corenavigation.GlobalNavigation
import com.playground.featureshowcase.domain.ShowCaseInteractor
import com.playground.featureshowcase.presentation.details.di.ShowCaseIdentifier
import com.playground.featureshowcase.presentation.model.ShowCaseItemModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ShowCaseDetailsPresenter
@Inject constructor(
    @ShowCaseIdentifier private val showCaseId: Long,
    private val showCaseInteractor: ShowCaseInteractor,
    private val mapper: ShowCaseItemModel.Mapper,
    @GlobalNavigation private val globalRouter: Router
) : BaseMvpPresenter<ShowCaseDetailsView>(CompositeDisposable()) {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val disposable = showCaseInteractor.getItemInfo(showCaseId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.hideLoading()
                    viewState.render(mapper.map(it))
                },
                {
                    viewState.hideLoading()
                },
                {
                    viewState.hideLoading()
                })
        compositeDisposable.add(disposable)
        viewState.showLoading()
    }

    fun purchaseClicked() {
        globalRouter.navigateTo(GlobalFeature.Purchase())
    }
}