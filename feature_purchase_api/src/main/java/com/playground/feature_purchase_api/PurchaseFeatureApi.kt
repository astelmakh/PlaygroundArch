package com.playground.feature_purchase_api

import com.playground.feature_purchase_api.starter.PurchaseStarter

interface PurchaseFeatureApi {

    fun purchaseStarter(): PurchaseStarter
}