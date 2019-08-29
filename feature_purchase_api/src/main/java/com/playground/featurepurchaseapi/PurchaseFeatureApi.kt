package com.playground.featurepurchaseapi

import com.playground.featurepurchaseapi.starter.PurchaseStarter

interface PurchaseFeatureApi {

    fun purchaseStarter(): PurchaseStarter
}