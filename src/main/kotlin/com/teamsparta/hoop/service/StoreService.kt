package com.teamsparta.hoop.service

import com.teamsparta.hoop.dto.StoreResponse
import com.teamsparta.hoop.repository.StoreRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class StoreService(private val storeRepository: StoreRepository) {

    fun getStores(situation : String, pageable: Pageable): Page<StoreResponse> {
        val result: Page<StoreResponse> =
            storeRepository.findBySituation(situation,pageable)
                .map { StoreResponse(
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
    fun getStores2(totalEvaluation: String, pageable: Pageable): Page<StoreResponse> {
        val result: Page<StoreResponse> =
            storeRepository.findByTotalEvaluation(totalEvaluation,pageable)
                .map { StoreResponse(
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




