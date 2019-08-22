package com.playground.corenavigation

sealed class IntentKey {

    class ShowCase: IntentKey()
    class Purchase(val image: String,
                   val title: String,
                   val description: String) : IntentKey()
}