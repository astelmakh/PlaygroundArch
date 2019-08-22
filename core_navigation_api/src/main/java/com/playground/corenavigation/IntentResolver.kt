package com.playground.corenavigation

import android.content.Context
import android.content.Intent

interface IntentResolver<in Key : IntentKey> {

    fun getIntent(context: Context, key: Key): Intent
}