package com.playground.feature_purchase_impl.starter

import android.content.Context
import com.playground.coreutils.di.general.PerFeature
import com.playground.feature_purchase_api.starter.PurchaseStarter
import com.playground.feature_purchase_impl.presentation.PurchaseActivity
import javax.inject.Inject

@PerFeature
class PurchaseStarterImpl
@Inject constructor() : PurchaseStarter {

    override fun start(context: Context) {
        context.startActivity(PurchaseActivity.getIntent(context))
    }
}