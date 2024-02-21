package com.teamsparta.hoop.service

import com.teamsparta.hoop.dto.StoreResponse
import com.teamsparta.hoop.repository.StoreRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class StoreService(private val storeRepository: StoreRepository) {

    /**
     *
     */
    fun getStores(): List<StoreResponse> {
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
                    firstReportDate = it.firstReportDate
                )
            }

        return result
    }

    /**
     *
     */
    fun getStores2(): List<StoreResponse> {
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
                    firstReportDate = it.firstReportDate
                )
            }

        return result
    }
}




