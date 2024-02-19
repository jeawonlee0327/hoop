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
            .filter { it.totalEvaluation == rating }//가져온 상점 정보 중에서 "totalEvaluation"이 입력받은 "rating"과 같은 상점만 필터링
            .sortedByDescending { it.monitoringDate }//필터링된 상점들을 "monitoringDate"를 기준으로 내림차순
            .map { StoreDto(it) }// 정렬된 상점 정보를 StoreDto 객체로 변환하여 리스트로
    }

    override fun getStoresBySituation(status: String): List<StoreDto> {
        return storeRepository.findAll()
            .filter { it.situation == status }
            .sortedByDescending { it.monitoringDate }
            .map { StoreDto(it) }
    }
//    .map { store -> StoreDto(
//        id = store.id,
//        shopName = store.shopName,
//        mallName = store.mallName,
//        domain = store.domain,
//        email = store.email,
//        phoneNumber = store.phoneNumber,
//        businessType = store.businessType,
//        address = store.address,
//        totalEvaluation = store.totalEvaluation,
//        situation = store.situation,
//        monitoringDate = store.monitoringDate
//        )} dto에 컨스트럭터로 긴거 안넣으며 여기에 이걸 넣어야 하기 때문


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