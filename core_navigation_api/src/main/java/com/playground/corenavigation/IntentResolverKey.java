package com.playground.corenavigation;

import dagger.MapKey;

@MapKey
public @interface IntentResolverKey {
    Class<? extends IntentKey> value();
}
