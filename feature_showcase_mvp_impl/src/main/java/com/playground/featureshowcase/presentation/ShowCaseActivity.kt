package com.playground.featureshowcase.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.transition.Fade
import com.playground.core_presentation_mvp.base.BaseMvpActivity
import com.playground.featureshowcase.R
import com.playground.featureshowcase.di.ShowCaseFeatureComponent
import com.playground.featureshowcase.di.ShowCaseFeatureInitializer
import com.playground.featureshowcase.di.ShowCaseNavigation
import com.playground.featureshowcase.presentation.navigation.ShowCaseNavigationScreens
import com.playground.featureshowcase.presentation.ui.ListToDetailsTransition
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

class ShowCaseActivity : BaseMvpActivity() {

    @field:[Inject ShowCaseNavigation] lateinit var router: Router
    @field:[Inject ShowCaseNavigation] lateinit var navigatorHolder: NavigatorHolder

    private val navigator = object : SupportAppNavigator(this, R.id.container) {
        override fun setupFragmentTransaction(
            command: Command?,
            currentFragment: Fragment?,
            nextFragment: Fragment?,
            fragmentTransaction: FragmentTransaction?
        ) {
            currentFragment?.let {
                nextFragment?.sharedElementEnterTransition = ListToDetailsTransition()
                nextFragment?.enterTransition = Fade()
                currentFragment.exitTransition = Fade()
//                nextFragment?.sharedElementReturnTransition = ListToDetailsTransition()
                (currentFragment as? SharedElementViewListener)?.getSharedView()?.let {
                    fragmentTransaction?.addSharedElement(it, "showcase_list_to_details")
                }
                fragmentTransaction?.setCustomAnimations(
                    0, 0,
                    R.anim.pop_enter_from_left,
                    R.anim.pop_exit_right
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as? ShowCaseFeatureInitializer)?.warmUpShowCaseFeature()
        ShowCaseFeatureComponent.get().inject(this)
        setContentView(R.layout.a_showcase)

        if (savedInstanceState == null) {
            router.navigateTo(ShowCaseNavigationScreens.List())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        if (isFinishing) {
            ShowCaseFeatureComponent.get().resetComponent()
        }
        super.onPause()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
            return
        }
        router.exit()
    }
}