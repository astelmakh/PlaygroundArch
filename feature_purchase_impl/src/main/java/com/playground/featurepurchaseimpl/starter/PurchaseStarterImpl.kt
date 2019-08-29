package com.playground.featurepurchaseimpl.starter

import android.content.Context
import com.playground.coreutils.di.general.PerFeature
import com.playground.featurepurchaseapi.starter.PurchaseStarter
import com.playground.featurepurchaseimpl.presentation.PurchaseActivity
import javax.inject.Inject

@PerFeature
class PurchaseStarterImpl
@Inject constructor() : PurchaseStarter {

    override fun start(context: Context) {
        context.startActivity(PurchaseActivity.getIntent(context))
    }
}