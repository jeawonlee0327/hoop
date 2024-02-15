package com.teamsparta.hoop.service

import com.teamsparta.hoop.dto.StoreDto
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
}