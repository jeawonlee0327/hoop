package com.teamsparta.hoop.service

import com.teamsparta.hoop.dto.StoreDto
import com.teamsparta.hoop.model.Store
import com.teamsparta.hoop.repository.StoreRepository
import org.springframework.stereotype.Service

@Service
class StoreServiceImpl(private val storeRepository: StoreRepository) : StoreService {

    override fun getStoresByTotalEvaluation(rating: Int): List<StoreDto> {
        return storeRepository.findAll()
            .filter { it.totalEvaluation == rating }
            .sortedByDescending { it.monitoringDate }
            .map { StoreDto(it) }
    }

    override fun getStoresBySituation(status: String): List<StoreDto> {
        return storeRepository.findAll()
            .filter { it.situation == status }
            .sortedByDescending { it.monitoringDate }
            .map { StoreDto(it) }
    }

    override fun getStoresByTotalEvaluationAndSituation(rating: Int, status: String): List<StoreDto> {
        return storeRepository.findAll()
            .filter { it.totalEvaluation == rating && it.situation == status }
            .sortedByDescending { it.monitoringDate }
            .map { StoreDto(it) }
    }

    override fun createStore(
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
    ): StoreDto {
        val store = storeRepository.save(
            Store(
                shopName = shopName,
                mallName = mallName,
                domain = domain,
                email = email,
                phoneNumber = phoneNumber,
                businessType = businessType,
                address = address,
                totalEvaluation = totalEvaluation,
                situation = situation,
                monitoringDate = monitoringDate
            )
        )
        return StoreDto(store)
    }

    override fun updateStore(
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
    ): StoreDto {
        val store = storeRepository.save(
            Store(
                id = id,
                shopName = shopName,
                mallName = mallName,
                domain = domain,
                email = email,
                phoneNumber = phoneNumber,
                businessType = businessType,
                address = address,
                totalEvaluation = totalEvaluation,
                situation = situation,
                monitoringDate = monitoringDate
            )
        )
        return StoreDto(store)
    }
}