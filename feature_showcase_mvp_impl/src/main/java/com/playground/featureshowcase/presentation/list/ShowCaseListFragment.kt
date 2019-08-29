package com.playground.featureshowcase.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.playground.corepresentationmvp.base.BaseMvpFragment
import com.playground.featureshowcase.R
import com.playground.featureshowcase.di.ShowCaseFeatureComponent
import com.playground.featureshowcase.presentation.SharedElementViewListener
import com.playground.featureshowcase.presentation.list.adapter.ShowCaseAdapter
import com.playground.featureshowcase.presentation.list.di.ShowCaseListScreenModule
import com.playground.featureshowcase.presentation.model.ShowCaseItemModel
import kotlinx.android.synthetic.main.f_showcase_list.*
import javax.inject.Inject

class ShowCaseListFragment : BaseMvpFragment(), ShowCaseListView, SharedElementViewListener {

    @InjectPresenter
    lateinit var presenter: ShowCaseListPresenter

    @Inject
    lateinit var adapter: ShowCaseAdapter

    private val component by lazy { ShowCaseFeatureComponent.get().showCaseListScreenComponent(ShowCaseListScreenModule(requireContext())) }

    private var sharedElement: AppCompatImageView? = null

    @ProvidePresenter
    fun providePresenter(): ShowCaseListPresenter {
        return component.showCaseListPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(R.layout.f_showcase_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        component.inject(this)
        setupUI()
        if (savedInstanceState == null) {
            presenter.init()
        }
    }

    private fun setupUI() {
        rvShowCase.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvShowCase.adapter = adapter
        adapter.onItemClickListener = { model, sharedElement ->
            this.sharedElement = sharedElement
            presenter.showCaseChosen(model)
        }

        swipeToRefreshContainer.setOnRefreshListener { presenter.refreshRequest() }
    }

    override fun renderShowCases(items: List<ShowCaseItemModel>) {
        adapter.replaceAll(items)
    }

    override fun hideLoading() {
        super.hideLoading()
        swipeToRefreshContainer.isRefreshing = false
    }

    override fun getSharedView(): View? = sharedElement

    companion object {

        fun newInstance(): ShowCaseListFragment {
            return ShowCaseListFragment()
        }
    }
}