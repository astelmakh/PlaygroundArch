package com.playground.featureshowcase.presentation.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.playground.core_presentation_mvp.base.BaseActivity
import com.playground.corenavigation.IntentKey
import com.playground.corenavigation.IntentResolver
import com.playground.featureshowcase.R
import com.playground.featureshowcase.di.ShowCaseFeatureComponent
import com.playground.featureshowcase.di.ShowCaseScreenModule
import com.playground.featureshowcase.presentation.list.adapter.ShowCaseAdapter
import com.playground.featureshowcase.presentation.list.model.ShowCaseItemModel
import kotlinx.android.synthetic.main.a_showcase.*
import javax.inject.Inject

class ShowCaseActivity : BaseActivity(), ShowCaseView {

    @InjectPresenter
    lateinit var presenter: ShowCasePresenter

    @Inject
    lateinit var adapter: ShowCaseAdapter

    private val component by lazy { ShowCaseFeatureComponent.get().showCaseScreenComponent(ShowCaseScreenModule(this)) }

    @ProvidePresenter
    fun providePresenter(): ShowCasePresenter {
        return component.showCaseScreenPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)

        setContentView(R.layout.a_showcase)
        setupUI()

        if (savedInstanceState == null) {
            presenter.init()
        }
    }

    private fun setupUI() {
        rvShowCase.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvShowCase.adapter = adapter
        adapter.onItemClickListener = { model -> presenter.showCaseChosen(model) }
    }

    override fun renderShowCases(items: List<ShowCaseItemModel>) {
        adapter.replaceAll(items)
    }

    companion object : IntentResolver<IntentKey.ShowCase> {

        override fun getIntent(context: Context, key: IntentKey.ShowCase): Intent {
            return Intent(context, ShowCaseActivity::class.java)
        }
    }
}