package com.playground.corenavigation

import android.content.Context
import android.content.Intent

interface Navigator {

    fun createIntent(context: Context, key: IntentKey): Intent
}