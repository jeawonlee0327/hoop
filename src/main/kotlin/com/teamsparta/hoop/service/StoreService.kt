package com.teamsparta.hoop.service

import com.teamsparta.hoop.dto.StoreResponse
import com.teamsparta.hoop.repository.StoreRepository
import org.springframework.stereotype.Service

@Service
class StoreService(private val storeRepository: StoreRepository) {

    /**
     *
     */
    fun getStores(status : String): List<StoreResponse> {
        val result: List<StoreResponse> =
            storeRepository.findAll().map {
                StoreResponse(
                    id = it.id,
                    shopName = it.shopName,
                    mallName = it.mallName,
                    domain = it.domain,
                    email = it.email,
                    phoneNumber = it.phoneNumber,
                    businessType = it.businessType,
                    address = it.address,
                    firstReportDate = it.firstReportDate,
                    totalEvaluation = it.totalEvaluation
                )
            }

        return result
    }

    /**
     *
     */
    fun getStores2(totalEvaluation: String): List<StoreResponse> {
        val message = when(totalEvaluation) {
            "in 2..3" -> "Good"
            "1" -> "Normal"
            "0" -> "Bad"
            else -> "unknown"
        }
        val result: List<StoreResponse> =
            storeRepository.findAll().map {
                StoreResponse(
                    id = it.id,
                    shopName = it.shopName,
                    mallName = it.mallName,
                    domain = it.domain,
                    email = it.email,
                    phoneNumber = it.phoneNumber,
                    businessType = it.businessType,
                    address = it.address,
                    firstReportDate = it.firstReportDate,
                    totalEvaluation = it.totalEvaluation
                )
            }

        return result
    }
}




