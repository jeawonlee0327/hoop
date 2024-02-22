package com.teamsparta.hoop.service

import com.teamsparta.hoop.dto.StoreDto
import org.springframework.web.multipart.MultipartFile

interface StoreService {
    fun getStoresByTotalEvaluation(rating: Int): List<StoreDto>
    fun getStoresBySituation(status: String): List<StoreDto>
    fun getStoresByTotalEvaluationAndSituation(rating: Int, status: String): List<StoreDto>
    fun searchStores(name: String?, domain: String?, email: String?): List<StoreDto>
    fun deleteStore(shopName: String)

    fun save(file: MultipartFile)






    fun createStore(
        shopName: String,
        mallName: String,
        domain: String,
        email: String,
        phoneNumber: String,
        businessType: String,
        address: String,
        totalEvaluation: Int,
        situation: String,
        monitoringDate: String
    ): StoreDto

    fun updateStore(
        id: Int,
        shopName: String,
        mallName: String,
        domain: String,
        email: String,
        phoneNumber: String,
        businessType: String,
        address: String,
        totalEvaluation: Int,
        situation: String,
        monitoringDate: String
    ): StoreDto
}