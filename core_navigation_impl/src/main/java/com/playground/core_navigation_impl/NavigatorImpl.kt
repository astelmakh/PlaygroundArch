package com.playground.core_navigation_impl

import android.content.Context
import android.content.Intent
import com.playground.corenavigation.IntentKey
import com.playground.corenavigation.IntentResolver
import com.playground.corenavigation.IntentResolverMap
import com.playground.corenavigation.Navigator
import javax.inject.Inject

open class NavigatorImpl @Inject constructor(
    private val intentResolvers: IntentResolverMap
) : Navigator {

    override fun createIntent(context: Context, key: IntentKey): Intent {
        val resolver = intentResolvers[key::class.java]?.get() as? IntentResolver<IntentKey>
        return (resolver?.getIntent(context, key)
            ?: throw IllegalStateException("Cannot resolve intent key $key")).apply { context.startActivity(this) }
    }
}
