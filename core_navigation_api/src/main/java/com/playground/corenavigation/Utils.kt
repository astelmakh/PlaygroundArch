package com.playground.corenavigation

import javax.inject.Provider

typealias IntentResolverMap =
    @JvmSuppressWildcards
    Map<Class<out IntentKey>, Provider<IntentResolver<*>>>