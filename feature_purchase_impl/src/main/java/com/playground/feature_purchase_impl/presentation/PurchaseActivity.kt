package com.playground.feature_purchase_impl.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.playground.core_presentation_mvp.base.BaseActivity
import com.playground.corenavigation.IntentKey
import com.playground.corenavigation.IntentResolver
import com.playground.feature_purchase_impl.R

class PurchaseActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_purchase)
    }

    companion object : IntentResolver<IntentKey.Purchase> {
        override fun getIntent(context: Context, key: IntentKey.Purchase): Intent {
            return Intent(context, PurchaseActivity::class.java)
        }
    }
}