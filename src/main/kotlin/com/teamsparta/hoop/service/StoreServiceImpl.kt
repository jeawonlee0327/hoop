package com.teamsparta.hoop.service

import com.teamsparta.hoop.exception.BusinessException
import com.teamsparta.hoop.dto.StoreDto
import com.teamsparta.hoop.repository.StoreRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StoreServiceImpl(
    private val storeRepository: StoreRepository
) : StoreService {

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
    override fun searchStores(
        name: String?,
        domain: String?,
        email: String?
    ): List<StoreDto> {
        return storeRepository.findAll()
            .filter { store ->
                (name == null || store.shopName.contains(name))
                        &&(domain == null || store.domain.contains(domain))
                        &&(email == null || store.email.contains(email))
            }
            .sortedByDescending { it.monitoringDate }
            .map { StoreDto(it) }
    }

    @Transactional
    override fun deleteStore(shopName: String) {
        try {
            val store = storeRepository.findByShopName(shopName)
            if (store != null) {
                storeRepository.delete(store)
            }
        } catch (e: NoSuchElementException) {
            throw BusinessException("업체를 찾을 수 없습니다. shopName: $shopName")
        }
    }

}