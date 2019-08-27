package com.playground.corenavigation

import ru.terrakok.cicerone.Screen

sealed class GlobalFeature : Screen() {

    class ShowCase : Screen()
    class Purchase : Screen()
    class Account : Screen()
}