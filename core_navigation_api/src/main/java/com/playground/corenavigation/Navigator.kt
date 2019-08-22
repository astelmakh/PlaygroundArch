package com.playground.corenavigation

import android.content.Intent

interface Navigator {

    fun createIntent(key: IntentKey): Intent
}