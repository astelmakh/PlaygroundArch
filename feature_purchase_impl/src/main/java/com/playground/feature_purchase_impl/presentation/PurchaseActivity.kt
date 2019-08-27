package com.playground.feature_purchase_impl.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.playground.core_presentation_mvp.base.BaseMvpActivity
import com.playground.feature_purchase_impl.R

class PurchaseActivity : BaseMvpActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_purchase)
    }

    companion object {

        fun getIntent(context: Context): Intent {
            return Intent(context, PurchaseActivity::class.java)
        }
    }
}