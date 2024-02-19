package com.teamsparta.hoop.service

import com.teamsparta.hoop.dto.StoreDto

interface StoreService {
    fun getStoresByTotalEvaluation(rating: Int): List<StoreDto>
    fun getStoresBySituation(status: String): List<StoreDto>
    fun getStoresByTotalEvaluationAndSituation(rating: Int, status: String): List<StoreDto>
    fun searchStores(name: String?, domain: String?, email: String?): List<StoreDto>
    fun deleteStore(shopName: String)
}