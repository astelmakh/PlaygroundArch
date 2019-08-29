package com.playground.featureshowcase.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.playground.corepresentationmvp.base.BaseMvpFragment
import com.playground.featureshowcase.R
import com.playground.featureshowcase.di.ShowCaseFeatureComponent
import com.playground.featureshowcase.presentation.details.di.ShowCaseDetailsScreenModule
import com.playground.featureshowcase.presentation.model.ShowCaseItemModel
import kotlinx.android.synthetic.main.f_showcase_details.*

class ShowCaseDetailsFragment : BaseMvpFragment(), ShowCaseDetailsView {

    private val component by lazy {
        ShowCaseFeatureComponent.get().showCaseDetailsScreenComponent(ShowCaseDetailsScreenModule(arguments?.getLong(ARGUMENT_SHOW_CASE_ID)
            ?: SHOW_CASE_ID_UNDEFINED))
    }

    @InjectPresenter lateinit var presenter: ShowCaseDetailsPresenter

    @ProvidePresenter
    fun providePresenter(): ShowCaseDetailsPresenter {
        return component.showCaseDetailsPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(requireContext()).inflate(R.layout.f_showcase_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        btnPurchase.setOnClickListener { presenter.purchaseClicked() }
    }

    override fun render(model: ShowCaseItemModel) {
        context?.let { ctx ->
            model.image?.let { image ->
                Glide.with(ctx)
                    .load(image)
                    .into(ivShowCase)
            }
        }
        tvShowCaseTitle.text = model.title
        tvShowCaseDescription.text = model.subtitle
    }

    companion object {
        private const val SHOW_CASE_ID_UNDEFINED = -1L
        private const val ARGUMENT_SHOW_CASE_ID = "com.playground.featureshowcase.ARGUMENT_SHOW_CASE_ID"

        fun newInstance(showCaseId: Long): ShowCaseDetailsFragment {
            val bundle = Bundle()
            bundle.putLong(ARGUMENT_SHOW_CASE_ID, showCaseId)
            val fragment = ShowCaseDetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}