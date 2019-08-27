package com.playground.featureshowcase.presentation.navigation

import androidx.fragment.app.Fragment
import com.playground.featureshowcase.presentation.details.ShowCaseDetailsFragment
import com.playground.featureshowcase.presentation.list.ShowCaseListFragment
import com.playground.featureshowcase.presentation.model.ShowCaseItemModel
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class ShowCaseNavigationScreens : SupportAppScreen() {

    class List : ShowCaseNavigationScreens() {
        override fun getFragment(): Fragment {
            return ShowCaseListFragment.newInstance()
        }
    }
    class Details(private val showCaseItemModel: ShowCaseItemModel) : ShowCaseNavigationScreens() {
        override fun getFragment(): Fragment {
            return ShowCaseDetailsFragment.newInstance(showCaseItemModel.id)
        }
    }
}